package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.FioName;

import java.util.List;

public class AllContactDeletionTests extends TestBase {

  @Test(enabled = false)
  public void testAllContactDeletion() {
    //удаление всех контактов в addressbook через страницу home с окном подтверждения
    app.goTo().homePage();
    app.contact().selectAllContact();
    app.contact().deleteAllSelectedContacts();
    app.contact().submitContactsDeletion();
    app.goTo().homePage();
    List<FioName> after = app.contact().list();
    Assert.assertEquals(after.size(), 0);
  }
}

