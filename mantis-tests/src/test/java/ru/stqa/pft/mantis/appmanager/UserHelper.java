package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase {

  public UserHelper(ApplicationManager app) {
    super(app);
    this.app = app;
  }

  public void selectUserFromResetPassword(int id) throws InterruptedException {
    startLogin(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
    goToControl();
    goToManageUser();
    goToSelectUser(id);
    resetPassword();
  }

  public void startLogin(String username, String password) throws InterruptedException {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    click(By.cssSelector("input[type='submit']"));
    type(By.name("password"), password);
    click(By.cssSelector("input[type='submit']"));
    Thread.sleep(2000);
  }

  public void goToControl() throws InterruptedException {
    click(By.cssSelector("button[id='menu-toggler']"));
    Thread.sleep(2000);
    click(By.cssSelector("a[href='/mantisbt-2.17.1/manage_overview_page.php']"));
  }

  public void goToManageUser() {
    click(By.cssSelector("a[href='/mantisbt-2.17.1/manage_user_page.php']"));

  }

  public void goToSelectUser(int id) {
    click(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']",id)));
  }

  public void resetPassword() {
    click(By.cssSelector("input[value='Сбросить пароль']"));
  }

  public void finish(String confirmationLink, String password) throws InterruptedException {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("span[class='bigger-110']"));
  }
}
