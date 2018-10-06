package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
  }

  @Test(enabled = true)
  public void testContactCreation() {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/6.jpg");
    ContactData contact = new ContactData().withFirstname("Alexey").withMiddlename("Vladimirovich")
            .withLastname("Ilyin").withCompany("iDSystems").withAddress("Tver").withHome("322322")
            .withMobile("89157237246").withWork("88001002320").withEmail("a.ilyin@id-sys.ru")
            .withEmail2("support@id-sys.ru").withDay(22).withMonth(8).withYear("1990")
            .withAddress2("Tver").withPhone2("Tver").withNotes("Hello").withGroup("test1")
            .withPhoto(photo);
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
