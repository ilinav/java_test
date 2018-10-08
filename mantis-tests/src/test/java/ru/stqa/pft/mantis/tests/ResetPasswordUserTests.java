package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordUserTests extends TestBase{

  @BeforeMethod
  public void startMailServer(){
    app.mail().start();
  }

  @Test
  public void testResetPassword() throws InterruptedException, IOException, MessagingException {

    //получаем данные первого пользователя, не администратора
    UserData user = app.db().users().iterator().next();
    int id = user.getId();
    String username = user.getUsername();
    String email = user.getEmail();
    String password_new = "password_new";

    //авторизуемся под администратором, выбираем этого пользователя, нажимаем "Сбросить пароль"
    app.userHelper().selectUserFromResetPassword(id);

    //получаем почту, выдергиваем линк
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);

    //заходим по линку, меняем пароль
    app.userHelper().finish(confirmationLink, password_new);

    //проверка авторизации под новым паролем
    HttpSession session = app.newSession();
    assertTrue(session.login(username,password_new));
    assertTrue(session.isLoggedInAs(username));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }
}