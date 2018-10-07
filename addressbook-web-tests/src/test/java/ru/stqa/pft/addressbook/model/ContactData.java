package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstname;
  @Expose
  private String middlename;
  @Expose
  private String lastname;
  @Expose
  @Transient
  private int day;
  @Expose
  @Transient
  private int month;
  @Expose
  @Column(name = "byear")
  private String year;
  @Expose
  private String company;
  @Expose
  @Type(type = "text")
  private String address;
  @Expose
  @Type(type = "text")
  private String email;
  @Expose
  @Type(type = "text")
  private String email2;
  @Expose
  @Type(type = "text")
  private String email3;
  @Expose
  @Type(type = "text")
  private String home;
  @Expose
  @Type(type = "text")
  private String mobile;
  @Expose
  @Type(type = "text")
  private String work;
  @Expose
  @Type(type = "text")
  private String address2;
  @Expose
  @Type(type = "text")
  private String phone2;

  @Expose
  @Type(type = "text")
  private String notes;
  @Expose
  @Transient
  private String group;
  @Type(type = "text")
  @Transient
  private String photo;
  @Transient
  private String allPhones;
  @Transient
  private String allMails;

  public File getPhoto() {
    if (photo != null) {
      return new File(photo);
    } else
      return null;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(middlename, that.middlename) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(year, that.year) &&
            Objects.equals(company, that.company) &&
            Objects.equals(address, that.address) &&
            Objects.equals(email, that.email) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(home, that.home) &&
            Objects.equals(mobile, that.mobile) &&
            Objects.equals(work, that.work) &&
            Objects.equals(address2, that.address2) &&
            Objects.equals(phone2, that.phone2) &&
            Objects.equals(notes, that.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, middlename, lastname, year, company, address, email, email2, home, mobile, work, address2, phone2, notes);
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

}
