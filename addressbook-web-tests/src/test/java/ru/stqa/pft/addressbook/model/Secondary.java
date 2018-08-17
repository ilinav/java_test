package ru.stqa.pft.addressbook.model;

public class Secondary {
  private final String address2;
  private final String phone2;
  private final String notes;
  private String group;

  public Secondary(String address2, String phone2, String notes, String group) {
    this.address2 = address2;
    this.phone2 = phone2;
    this.notes = notes;
    this.group = group;
  }

  public String getAddress2() {
    return address2;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getNotes() {
    return notes;
  }

  public String getGroup() {
    return group;
  }
}
