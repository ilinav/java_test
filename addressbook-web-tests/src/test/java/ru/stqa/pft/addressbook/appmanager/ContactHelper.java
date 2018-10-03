package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillNewAddress(FioName fioName, InfoCompany infoCompany, InfoMobile infoMobile, InfoEmail infoEmail, InfoBirchDate infoBirchDate, Secondary secondary, boolean creation) {
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

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(secondary.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectAllContact() {
    if (!wd.findElement(By.id("MassCB")).isSelected()) {
      wd.findElement(By.id("MassCB")).click();
    }
  }

  public void initAddNew() {
    click(By.linkText("add new"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void deleteAllSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void submitContactsDeletion() {
    wd.switchTo().alert().accept();
  }

  public void modificationContact(int index) {
    wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr/td[8]/a/img")).get(index).click();
  }

  public void selectContact(int index) {
    wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr/td/input")).get(index).click();
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void create(FioName fioName, InfoCompany infoCompany, InfoMobile infoMobile, InfoEmail infoEmail, InfoBirchDate infoBirchDate, Secondary secondary, boolean creation) {
    initAddNew();
    fillNewAddress(fioName,infoCompany,infoMobile,infoEmail,infoBirchDate,secondary,creation);
    submitContactCreation();
    returnToHomePage();
  }

  public void modify(int index, FioName contact) {
    modificationContact(index);
    fillNewAddress(contact, new InfoCompany("iDSystems", "Tver"), new InfoMobile("322322", "89157237246", "88001002320"), new InfoEmail("a.ilyin@id-sys.ru", "support@id-sys.ru"), new InfoBirchDate(22, 8, "1990"), new Secondary("Tver", "Tver", "Hello",null),false);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteAllSelectedContacts();
    submitContactsDeletion();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public List<FioName> list() {
    List<FioName> contacts = new ArrayList<FioName>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements){
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new FioName().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }
}
