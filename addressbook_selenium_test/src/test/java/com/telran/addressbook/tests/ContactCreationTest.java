package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


public class ContactCreationTest extends TestBase {

    @Test //(priority = 3)
    public void testContactCreationLongName() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().initContactCreation();

        File photo = new File("src/test/resources/images.jpeg"); // adding a file

        app.getContactsHelper().fillContactForm(new ContactData()
                .withFirstName("Long_name")
                .withLastName("Long_lastName")
                .withTitle("long_title_1")
                .withCompany("Apple")
                .withAddress("Tel Aviv")
                .withPhone("0540044040")
                .withEmail("user1@mail.com")
                .withCompanyAddress("Herzliya")
                .withPhoto(photo)
                .withGroup("myName"));

        app.getContactsHelper().submitContactCreation();
        app.getContactsHelper().returnToHomePage();
        int after = app.getContactsHelper().GetContactCount();

        System.out.println("1 method: testContactCreationLongName() PASSED");
        Assert.assertEquals(after, before + 1);
    }

    @Test //(priority = 1, enabled = false)
    public void testContactCreationShortName() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().initContactCreation();

        app.getContactsHelper().fillContactForm(new ContactData()
                .withFirstName("name").withLastName("lastName")
                .withTitle("title1").withCompany("A").withAddress("TA")
                .withPhone("054...").withEmail("u1@mail.com").withCompanyAddress("H").withGroup("myName"));

        app.getContactsHelper().submitContactCreation();
        app.getContactsHelper().returnToHomePage();
        int after = app.getContactsHelper().GetContactCount();

        System.out.println("2 method: testContactCreationShortName() PASSED");
        Assert.assertEquals(after, before + 1);
    }

    @Test //(priority = 2, enabled = false)
    public void testContactCreationNoName() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().initContactCreation();
        app.getContactsHelper().fillContactForm(new ContactData().withGroup("n1"));
        app.getContactsHelper().submitContactCreation();
        app.getContactsHelper().returnToHomePage();
        int after = app.getContactsHelper().GetContactCount();

        System.out.println("3 method: testContactCreationNoName() PASSED");
        Assert.assertEquals(after, before + 1);
    }
}
