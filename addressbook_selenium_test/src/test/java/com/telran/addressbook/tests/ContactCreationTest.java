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
                        .setFirstName("Long_name").setLastName("Long_lastname")
                        .setTitle("long_title_1").setCompany("Apple").setAddress("Tel Aviv")
                        .setPhone("0540044040").setEmail("user1@mail.com").setCompanyAddress("Herzliya"));

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
                .setFirstName("name").setLastName("lastname")
                .setTitle("title1").setCompany("A").setAddress("TA")
                .setPhone("054...").setEmail("u1@mail.com").setCompanyAddress("H"));

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
