package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion() {
    //удаление первого контакта в addressbook через форму модификации без подтверждения
    //выбор нужного контакта через страницу home невозможен, так как у каждого нового клиента свой уникальный ID чекбокса
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().modificationContact();
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelper().gotoHomePage();
  }
}
