package ru.stqa.pft.addressbook.model;

public class InfoMobile extends ContactData {
  private String home;
  private String mobile;
  private String work;

  public InfoMobile withHome(String home) {
    this.home = home;
    return this;
  }

  public InfoMobile withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public InfoMobile withWork(String work) {
    this.work = work;
    return this;
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
