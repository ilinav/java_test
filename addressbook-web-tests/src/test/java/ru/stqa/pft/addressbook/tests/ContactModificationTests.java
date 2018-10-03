package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().list().size() == 0){
      app.contact().create(new FioName()
              .withFirstname("Alexey").withMiddlename("Vladimirovich").withLastname("Ilyin"), new InfoCompany("iDSystems", "Tver"), new InfoMobile("322322", "89157237246", "88001002320"), new InfoEmail("a.ilyin@id-sys.ru", "support@id-sys.ru"), new InfoBirchDate(22, 8, "1990"), new Secondary("Tver", "Tver", "Hello", "test1"),true);
    }
  }

  @Test(enabled = true)
  public void testNewAddressCreation() {
    List<FioName> before = app.contact().list();
    int index = before.size() - 1;
    FioName contact = new FioName()
            .withId(before.get(index).getId()).withFirstname("Alexey").withMiddlename("Vladimirovich").withLastname("Ilyin");
    app.contact().modify(index, contact);
    List<FioName> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super FioName> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId()) ;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}