package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size() == 0){
      app.contact().create( new ContactData().withFirstname("Alexey").withMiddlename("Vladimirovich").withLastname("Ilyin").withCompany("iDSystems").withAddresscompany("Tver").withHome("322322").withMobile("89157237246").withWork("88001002320").withEmail("a.ilyin@id-sys.ru").withEmail2("support@id-sys.ru").withDay(22).withMonth(8).withYear("1990").withAddress2("Tver").withPhone2("Tver").withNotes("Hello").withGroup("test1"),true);
    }
  }

  @Test(enabled = true)
  public void testNewAddressCreation() {
    Contacts before = app.contact().all();
    ContactData modifyContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifyContact.getId()).withFirstname("Алексей").withMiddlename("Владимирович").withLastname("Ильин");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
  }
}