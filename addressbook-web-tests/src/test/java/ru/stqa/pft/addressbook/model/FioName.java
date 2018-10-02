package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class FioName {
  private int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;

  public int getId() {
    return id;
  }

  public FioName(int id, String firstname, String middlename, String lastname) {
    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
  }

  public void setId(int id) {
    this.id = id;
  }

  public FioName(String firstname, String middlename, String lastname) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FioName fioName = (FioName) o;
    return Objects.equals(firstname, fioName.firstname) &&
            Objects.equals(lastname, fioName.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }

  @Override
  public String toString() {
    return "FioName{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }
}
