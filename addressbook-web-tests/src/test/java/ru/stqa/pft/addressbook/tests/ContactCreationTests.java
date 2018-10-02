package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<FioName> before = app.getContactHelper().getContactList();
    FioName contact = new FioName("Alexey", "Vladimirovich", "Ilyin");
    app.getContactHelper().createContact(contact, new InfoCompany("iDSystems", "Tver"), new InfoMobile("322322", "89157237246", "88001002320"), new InfoEmail("a.ilyin@id-sys.ru", "support@id-sys.ru"), new InfoBirchDate(22, 8, "1990"), new Secondary("Tver", "Tver", "Hello", "test1"), true);
    List<FioName> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super FioName> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId()) ;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
