package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator{

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse((args));
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try(Writer writer = new FileWriter(file)){
      writer.write(json);
    }
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try(Writer writer = new FileWriter(file)){
      writer.write(xml);
    }
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    try(Writer writer = new FileWriter(file)){
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s\n", contact.getFirstname(), contact.getMiddlename(), contact.getLastname(), contact.getCompany(), contact.getAddress()
                , contact.getHome(), contact.getMobile(), contact.getWork(), contact.getEmail(), contact.getEmail2(), contact.getEmail3(), contact.getDay(), contact.getMonth()
                , contact.getYear(), contact.getAddress2(), contact.getPhone2(), contact.getNotes()));//, contact.getGroup()));
      }
    }
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    File photo = new File("src/test/resources/6.jpg");
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstname(String.format("Alexey %s", i)).withMiddlename(String.format("Vladimirovich %s", i))
              .withLastname(String.format("Ilyin %s", i)).withCompany(String.format("iDSystems %s", i)).withAddress(String.format("Tver %s", i)).withHome(String.format("322322%s", i))
              .withMobile(String.format("89157237246%s", i)).withWork(String.format("88001002320%s", i)).withEmail(String.format("a.ilyin%s@id-sys.ru", i))
              .withEmail2(String.format("support%s@id-sys.ru", i)).withDay(i + 1).withMonth(i + 1).withYear(String.format("199%s", i))
              .withAddress2(String.format("Tver %s", i)).withPhone2(String.format("Tver%s", i)).withNotes(String.format("Hello %s", i)).withGroup("test 1").withPhoto(photo));
    }
    return contacts;
  }
}