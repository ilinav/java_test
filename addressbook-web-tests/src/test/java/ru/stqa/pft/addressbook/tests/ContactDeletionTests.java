package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size() == 0){
      app.contact().create( new ContactData().withFirstname("Alexey").withMiddlename("Vladimirovich").withLastname("Ilyin").withCompany("iDSystems").withAddress("Tver").withHome("322322").withMobile("89157237246").withWork("88001002320").withEmail("a.ilyin@id-sys.ru").withEmail2("support@id-sys.ru").withDay(22).withMonth(8).withYear("1990").withAddress2("Tver").withPhone2("Tver").withNotes("Hello").withGroup("test1"),true);
    }
  }

  @Test(enabled = true)
  public void testContactDeletion() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
