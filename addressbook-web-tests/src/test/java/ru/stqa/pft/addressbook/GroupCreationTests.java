package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreations();
    fillGroupForm(new GroupData("test11", "test22", "test33"));
    submitGroupCreations();
    gotoGroupPage();
  }

}
