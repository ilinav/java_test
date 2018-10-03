package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.Set;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size() == 0){
      app.contact().create(new FioName()
              .withFirstname("Alexey").withMiddlename("Vladimirovich").withLastname("Ilyin"), new InfoCompany("iDSystems", "Tver"), new InfoMobile("322322", "89157237246", "88001002320"), new InfoEmail("a.ilyin@id-sys.ru", "support@id-sys.ru"), new InfoBirchDate(22, 8, "1990"), new Secondary("Tver", "Tver", "Hello", "test1"),true);
    }
  }

  @Test(enabled = true)
  public void testNewAddressCreation() {
    Set<FioName> before = app.contact().all();
    FioName modifyContact = before.iterator().next();
    FioName contact = new FioName()
            .withId(modifyContact.getId()).withFirstname("Алексей").withMiddlename("Владимирович").withLastname("Ильин");
    app.contact().modify(contact);
    Set<FioName> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifyContact);
    before.add(contact);
    Assert.assertEquals(before,after);
  }
}