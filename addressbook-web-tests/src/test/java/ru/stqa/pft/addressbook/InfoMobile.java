package ru.stqa.pft.addressbook;

public class InfoMobile {
  private final String home;
  private final String mobile;
  private final String work;

  public InfoMobile(String home, String mobile, String work) {
    this.home = home;
    this.mobile = mobile;
    this.work = work;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }
}
