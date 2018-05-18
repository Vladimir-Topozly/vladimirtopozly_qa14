package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test(priority = 3)
    public void testContactCreationLongName() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().initContactCreation();
        app.getContactsHelper().fillContact(
                new ContactData("Long_name", "Long_lastname", "long_title_1",
                        "Apple", "Herzliya", "0540044040",
                        "user1@mail.com", "Tel Aviv"));
        app.getContactsHelper().submitContactCreation();
        app.getContactsHelper().returnToHomePage();
        int after = app.getContactsHelper().GetContactCount();
        System.out.println("testContactCreationLongName() passed");

        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 2)
    public void testContactCreationShortName() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().initContactCreation();
        app.getContactsHelper().fillContact(
                new ContactData("name", "lastname", "title1", "A",
                        "H", "054...", "user1@mail.com", "TA"));
        app.getContactsHelper().submitContactCreation();
        app.getContactsHelper().returnToHomePage();
        int after = app.getContactsHelper().GetContactCount();
        System.out.println("testContactCreationShortName() passed");

        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 1)
    public void testContactCreationEmpty() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().initContactCreation();
        app.getContactsHelper().fillContact(
                new ContactData("", "", "", "", "",
                        "", "", ""));
        app.getContactsHelper().submitContactCreation();
        app.getContactsHelper().returnToHomePage();
        int after = app.getContactsHelper().GetContactCount();
        System.out.println("testContactCreationEmpty() passed");

        Assert.assertEquals(after, before + 1);
    }

}