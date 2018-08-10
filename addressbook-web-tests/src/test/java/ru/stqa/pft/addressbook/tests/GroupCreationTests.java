package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.gotoGroupPage();
    app.initGroupCreations();
    app.fillGroupForm(new GroupData("test11", "test22", "test33"));
    app.submitGroupCreations();
    app.gotoGroupPage();
  }

}
