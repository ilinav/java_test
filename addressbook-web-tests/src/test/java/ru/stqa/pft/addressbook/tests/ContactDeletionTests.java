package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion() {
    //удаление первого контакта в addressbook через форму модификации без подтверждения
    //выбор нужного контакта через страницу home невозможен, так как у каждого нового клиента свой уникальный ID чекбокса
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new FioName("Alexey", "Vladimirovich", "Ilyin"), new InfoCompany("iDSystems", "Tver"), new InfoMobile("322322", "89157237246", "88001002320"), new InfoEmail("a.ilyin@id-sys.ru", "support@id-sys.ru"), new InfoBirchDate(22, 8, "1990"), new Secondary("Tver", "Tver", "Hello", "test1"),true);
    }
    app.getContactHelper().modificationContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().returnToHomePage();
  }
}
