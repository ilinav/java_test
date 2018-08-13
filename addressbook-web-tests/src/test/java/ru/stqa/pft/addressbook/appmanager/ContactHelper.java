package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.*;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillNewAddress(FioName fioName, InfoCompany infoCompany, InfoMobile infoMobile, InfoEmail infoEmail, InfoBirchDate infoBirchDate, Secondary secondary) {
    type(By.name("firstname"), fioName.getFirstname());
    type(By.name("middlename"), fioName.getMiddlename());
    type(By.name("lastname"), fioName.getLastname());
    type(By.name("company"), infoCompany.getCompany());
    type(By.name("address"), infoCompany.getAddresscompany());
    type(By.name("home"), infoMobile.getHome());
    type(By.name("mobile"), infoMobile.getMobile());
    type(By.name("work"), infoMobile.getWork());
    type(By.name("email"), infoEmail.getEmail());
    type(By.name("email2"), infoEmail.getEmail2());
    getElement(infoBirchDate.getDay(), 1);
    getElement(infoBirchDate.getMonth(), 2);
    type(By.name("byear"), infoBirchDate.getYear());
    type(By.name("address2"), secondary.getAddress2());
    type(By.name("phone2"), secondary.getPhone2());
    type(By.name("notes"), secondary.getNotes());
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectAllContact() {
    if (!wd.findElement(By.id("MassCB")).isSelected()) {
      wd.findElement(By.id("MassCB")).click();
    }
  }

  public void deleteAllSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void submitContactsDeletion() {
    wd.switchTo().alert().accept();
  }

  public void modificationContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }
}
