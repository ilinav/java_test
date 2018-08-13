package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class AllContactDeletionTests extends TestBase {

  @Test
  public void testAllContactDeletion() {
    //удаление всех контактов в addressbook через страницу home с окном подтверждения
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectAllContact();
    app.getContactHelper().deleteAllSelectedContacts();
    app.getContactHelper().submitContactsDeletion();
    app.getNavigationHelper().gotoHomePage();
  }
}

