package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.security.acl.Group;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactRemoveGroupTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().groups().size() == 0){
      app.goTo().groupPage();
      app.group().create( new GroupData().withName("test 1").withHeader("test 1").withFooter("test 1"));
    }
    if (app.db().contacts().size() == 0){
      app.goTo().homePage();
      Groups groups = app.db().groups();
      app.contact().create( new ContactData().withFirstname("Alexey").withMiddlename("Vladimirovich")
              .withLastname("Ilyin").withCompany("iDSystems").withAddress("Tver").withHome("322322")
              .withMobile("89157237246").withWork("88001002320").withEmail("a.ilyin@id-sys.ru")
              .withEmail2("support@id-sys.ru").withDay(22).withMonth(8).withYear("1990").withAddress2("Tver")
              .withPhone2("Tver").withNotes("Hello").inGroup(groups.iterator().next()),true);
    }
    app.goTo().homePage();
  }

  @Test
  public void testContactRemoveGroup() {
    ContactData contact = app.db().contacts().iterator().next();
    int i = contact.getId();
    System.out.println(contact.getGroups().size());
       if(contact.getGroups().size() == 0){
         GroupData new_group = app.db().groups().iterator().next();
         app.contact().contactToGroup(contact,new_group);
         app.goTo().homePage();
    }
    ContactData new_contact = app.db().getContactOfGroup(i);
    Groups groupDelete = new_contact.getGroups();
    app.contact().contactRemoveGroup(new_contact);
    assertThat(app.db().getContactOfGroup(contact.getId()).getGroups().contains(groupDelete), equalTo(false));
  }
}
