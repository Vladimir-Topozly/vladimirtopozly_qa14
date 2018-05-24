package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ContactCreationTest extends TestBase {

    @Test //(priority = 1)
    public void testContactCreationLongName() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().initContactCreation();

        app.getContactsHelper().fillContactForm(new ContactData()
                        .withFirstName("Long_name").withLastName("Long_lastName")
                        .withTitle("long_title_1").withCompany("Apple").withAddress("Tel Aviv")
                        .withPhone("0540044040").withEmail("user1@mail.com").withCompanyAddress("Herzliya"));

        app.getContactsHelper().submitContactCreation();
        app.getContactsHelper().returnToHomePage();
        int after = app.getContactsHelper().GetContactCount();

        System.out.println("1 method: testContactCreationLongName() PASSED");
        Assert.assertEquals(after, before + 1);
    }

    @Test //(priority = 2)
    public void testContactCreationShortName() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().initContactCreation();

        app.getContactsHelper().fillContactForm(new ContactData()
                .withFirstName("name").withLastName("lastName")
                .withTitle("title1").withCompany("A").withAddress("TA")
                .withPhone("054...").withEmail("u1@mail.com").withCompanyAddress("H"));

        app.getContactsHelper().submitContactCreation();
        app.getContactsHelper().returnToHomePage();
        int after = app.getContactsHelper().GetContactCount();

        System.out.println("2 method: testContactCreationShortName() PASSED");
        Assert.assertEquals(after, before + 1);
    }

    @Test //(priority = 0)
    public void testContactCreationEmpty() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().initContactCreation();
        app.getContactsHelper().fillContactForm(new ContactData());
        app.getContactsHelper().submitContactCreation();
        app.getContactsHelper().returnToHomePage();
        int after = app.getContactsHelper().GetContactCount();

        System.out.println("3 method: testContactCreationEmpty() PASSED");
        Assert.assertEquals(after, before + 1);
    }
}
