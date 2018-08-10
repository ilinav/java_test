package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.*;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillNewAddress(FioName fioName, InfoCompany infoCompany, InfoMobile infoMobile, InfoEmail infoEmail, InfoBirchDate infoBirchDate, Secondary secondary) {
    type(By.name("firstname"),fioName.getFirstname());
    type(By.name("middlename"),fioName.getMiddlename());
    type(By.name("lastname"),fioName.getLastname());
    type(By.name("company"),infoCompany.getCompany());
    type(By.name("address"),infoCompany.getAddresscompany());
    type(By.name("home"),infoMobile.getHome());
    type(By.name("mobile"),infoMobile.getMobile());
    type(By.name("work"),infoMobile.getWork());
    type(By.name("email"),infoEmail.getEmail());
    type(By.name("email2"),infoEmail.getEmail2());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[" + infoBirchDate.getDay() + "]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[" + infoBirchDate.getDay() + "]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[" + infoBirchDate.getMonth() + "]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[" + infoBirchDate.getMonth() + "]")).click();
    }
    type(By.name("byear"),infoBirchDate.getYear());
    type(By.name("address2"),secondary.getAddress2());
    type(By.name("phone2"),secondary.getPhone2());
    type(By.name("notes"),secondary.getNotes());
  }

  public void SubmitAddressCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

}
