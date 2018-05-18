package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test(priority = 3)
    public void testContactCreationLongName() {
        app.goToHomePage();
        int before = app.GetContactCount();
        app.initContactCreation();
        app.fillContact(
                new ContactData("Long_name", "Long_lastname", "long_title_1",
                        "Apple", "Herzliya", "0540044040",
                        "user1@mail.com", "Tel Aviv"));
        app.submitContactCreation();
        app.returnToHomePage();
        int after = app.GetContactCount();
        System.out.println("testContactCreationLongName() passed");

        Assert.assertEquals(after, before+1);
    }

    @Test(priority = 2, enabled = true)
    public void testContactCreationShortName() {
        app.goToHomePage();
        int before = app.GetContactCount();
        app.initContactCreation();
        app.fillContact(
                new ContactData("name", "lastname", "title1", "A",
                        "H", "054...", "user1@mail.com", "TA"));
        app.submitContactCreation();
        app.returnToHomePage();
        int after = app.GetContactCount();
        System.out.println("testContactCreationShortName() passed");

        Assert.assertEquals(after, before+1);
    }

    @Test(priority = 1, enabled = true)
    public void testContactCreationEmpty() {
        app.goToHomePage();
        int before = app.GetContactCount();
        app.initContactCreation();
        app.fillContact(
                new ContactData("", "", "", "", "",
                        "", "", ""));
        app.submitContactCreation();
        app.returnToHomePage();
        int after = app.GetContactCount();
        System.out.println("testContactCreationEmpty() passed");

        Assert.assertEquals(after, before+1);
    }

}
