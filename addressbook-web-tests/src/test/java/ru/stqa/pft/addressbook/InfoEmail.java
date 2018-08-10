package ru.stqa.pft.addressbook;

public class InfoEmail {
  private final String email;
  private final String email2;

  public InfoEmail(String email, String email2) {
    this.email = email;
    this.email2 = email2;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }
}
