package ru.stqa.pft.addressbook.model;

public class InfoCompany {
  private final String company;
  private final String addresscompany;

  public InfoCompany(String company, String addresscompany) {
    this.company = company;
    this.addresscompany = addresscompany;
  }

  public String getCompany() {
    return company;
  }

  public String getAddresscompany() {
    return addresscompany;
  }
}
