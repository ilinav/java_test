package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddGroupTests extends TestBase{

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
  public void testContactAddGroup() {
    ContactData contact = app.db().contacts().iterator().next();
    GroupData group = app.db().groups().iterator().next();
    app.contact().contactToGroup(contact,group);

    assertThat(app.db().getContactOfGroup(contact.getId()).getGroups().contains(group), equalTo(true));

  }
}
