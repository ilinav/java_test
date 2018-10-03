package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class FioName {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;

  public int getId() {
    return id;
  }

  public FioName withId(int id) {
    this.id = id;
    return this;
  }

  public FioName withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public FioName withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public FioName withLastname(String lastname) {
    this.lastname = lastname;
    return this;
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
    return "FioName{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FioName fioName = (FioName) o;
    return id == fioName.id &&
            Objects.equals(firstname, fioName.firstname) &&
            Objects.equals(lastname, fioName.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }
}
