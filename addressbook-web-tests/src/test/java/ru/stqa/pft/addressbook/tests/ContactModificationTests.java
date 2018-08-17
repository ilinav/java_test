package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

public class ContactModificationTests extends TestBase{

  @Test
  public void testNewAddressCreation() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().modificationContact();
    app.getContactHelper().fillNewAddress(new FioName("Ivan", "Ivanovich", "Ivanov"), new InfoCompany("iDSystems", "Tver"), new InfoMobile("322322", "89157237246", "88001002320"), new InfoEmail("a.ilyin@id-sys.ru", "support@id-sys.ru"), new InfoBirchDate(22, 8, "1990"), new Secondary("Tver", "Tver", "Hello",null),false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}