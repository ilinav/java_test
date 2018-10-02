package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.List;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new FioName("Alexey", "Vladimirovich", "Ilyin"), new InfoCompany("iDSystems", "Tver"), new InfoMobile("322322", "89157237246", "88001002320"), new InfoEmail("a.ilyin@id-sys.ru", "support@id-sys.ru"), new InfoBirchDate(22, 8, "1990"), new Secondary("Tver", "Tver", "Hello", "test1"),true);
    }
    List<FioName> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteAllSelectedContacts();
    app.getContactHelper().submitContactsDeletion();
    app.getContactHelper().returnToHomePage();
    List<FioName> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
