package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.FioName;

import java.util.List;

public class AllContactDeletionTests extends TestBase {

  @Test(enabled = false)
  public void testAllContactDeletion() {
    //удаление всех контактов в addressbook через страницу home с окном подтверждения
    app.getNavigationHelper().gotoHomePage();
    List<FioName> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectAllContact();
    app.getContactHelper().deleteAllSelectedContacts();
    app.getContactHelper().submitContactsDeletion();
    app.getNavigationHelper().gotoHomePage();
    List<FioName> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), 0);
  }
}

