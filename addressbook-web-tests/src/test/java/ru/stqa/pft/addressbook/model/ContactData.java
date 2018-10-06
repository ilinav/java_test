package ru.stqa.pft.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;
  private int day;
  private int month;
  private String year;
  private String company;
  private String address;
  private String email;
  private String email2;
  private String email3;
  private String home;
  private String mobile;
  private String work;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  private String address2;
  private String phone2;
  private String notes;
  private String group;
  private String allPhones;
  private String allMails;
  private File photo;

  public String getAllMails() {
    return allMails;
  }

  public ContactData withAllMails(String allMails) {
    this.allMails = allMails;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withDay(int day) {
    this.day = day + 2;
    return this;
  }

  public ContactData withMonth(int month) {
    this.month = month + 1;
    return this;
  }

  public ContactData withYear(String year) {
    this.year = year;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withPhone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }


  public ContactData withHome(String home) {
    this.home = home;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWork(String work) {
    this.work = work;
    return this;
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


  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
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

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData contactData = (ContactData) o;
    return id == contactData.id &&
            Objects.equals(firstname, contactData.firstname) &&
            Objects.equals(lastname, contactData.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }
}
