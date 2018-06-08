package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ContactCreationTest extends TestBase {
    @DataProvider
    public Iterator<Object[]>validContacts() throws FileNotFoundException {
        List<Object> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(
                new File("crc/test/resources/contacts.csv")));

        return null; //TODO: adapt all @Test methods so as they work with the DataProvider
    }

    @Test //(priority = 3)
    public void testContactCreationLongName() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().initContactCreation();

        File photo = new File("src/test/resources/image.jpeg"); // adding a file

        app.getContactsHelper().fillContactForm(new ContactData()
                .withFirstName("With_IMAGE__name1")
                .withLastName("Long_lastName")
                .withTitle("long_title_1")
                .withCompany("Apple")
                .withAddress("Tel Aviv")
                .withPhone("0540044040")
                .withEmail("user1@mail.com")
                .withCompanyAddress("Herzliya")
                .withPhoto(photo)
                .withGroup("testName 1"));

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
                .withFirstName("name")
                .withLastName("lastName")
                .withTitle("title1")
                .withCompany("A")
                .withAddress("TA")
                .withPhone("054...")
                .withEmail("u1@mail.com")
                .withCompanyAddress("H")
                .withGroup("testName 2"));

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
        app.getContactsHelper().fillContactForm(new ContactData().withGroup("testName 3"));
        app.getContactsHelper().submitContactCreation();
        app.getContactsHelper().returnToHomePage();
        int after = app.getContactsHelper().GetContactCount();

        System.out.println("3 method: testContactCreationNoName() PASSED");
        Assert.assertEquals(after, before + 1);
    }
}
