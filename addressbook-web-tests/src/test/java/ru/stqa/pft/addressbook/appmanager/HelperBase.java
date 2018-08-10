package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelperBase {
  protected FirefoxDriver wd;

  public HelperBase(FirefoxDriver wd) {
    this.wd=wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected void getElement(int number, int num_element) {
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select["+num_element+"]//option[" + number + "]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select["+num_element+"]//option[" + number + "]")).click();
    }
  }
}
