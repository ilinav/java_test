package ru.stqa.pft.addressbook.model;

public class InfoBirchDate {
  private final int day;
  private final int month;
  private final String year;

  public InfoBirchDate(int day, int month, String year) {
    this.day = day + 2;
    this.month = month + 1;
    this.year = year;
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }
}
