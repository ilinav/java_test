package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillNewAddress(ContactData contactData, InfoCompany infoCompany, InfoMobile infoMobile, InfoEmail infoEmail, InfoBirchDate infoBirchDate, Secondary secondary, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
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

  private void modificationContactById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector(String.format("input[value='%s']", id))).click();
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void create(ContactData contactData, InfoCompany infoCompany, InfoMobile infoMobile, InfoEmail infoEmail, InfoBirchDate infoBirchDate, Secondary secondary, boolean creation) {
    initAddNew();
    fillNewAddress(contactData, infoCompany, infoMobile, infoEmail, infoBirchDate, secondary, creation);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    modificationContactById(contact.getId());
    fillNewAddress(contact, new InfoCompany("iDSystems", "Tver"), new InfoMobile().withHome("322322").withMobile("89157237246").withWork("88001002320"), new InfoEmail("a.ilyin@id-sys.ru", "support@id-sys.ru"), new InfoBirchDate(22, 8, "1990"), new Secondary("Tver", "Tver", "Hello", null), false);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteAllSelectedContacts();
    submitContactsDeletion();
    contactCache = null;
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String[] phones = element.findElement(By.xpath(".//td[6]")).getText().split("\n");
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    modificationContactById(contact.getId());
    //String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    //String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new InfoMobile().withHome(home).withMobile(mobile).withWork(work);
    //return new ContactData().withId(contact.getId()).withFirstname(firstname)
    //        .withLastname(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }
}
