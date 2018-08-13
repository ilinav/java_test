package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    app.getNavigationHelper().initAddNew();
    app.getContactHelper().fillNewAddress(new FioName("Alexey", "Vladimirovich", "Ilyin"), new InfoCompany("iDSystems", "Tver"), new InfoMobile("322322", "89157237246", "88001002320"), new InfoEmail("a.ilyin@id-sys.ru", "support@id-sys.ru"), new InfoBirchDate(22, 8, "1990"), new Secondary("Tver", "Tver", "Hello"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }
}