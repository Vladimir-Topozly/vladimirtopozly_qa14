package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ContactCreationTest extends TestBase { //TODO: adapt all @Test methods so as they work with the DataProvider

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(
                new File("src/test/resources/contacts.csv")));

        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData()
                    .withFirstName(split[0])
                    .withLastName(split[1])
                    .withTitle(split[2])
                    .withCompany(split[3])
                    .withAddress(split[4])
                    .withPhone(split[5])
                    .withEmail(split[6])
                    .withCompanyAddress(split[7])
                    .withGroup(split[8])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreationLongName(ContactData contact) {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().initContactCreation();

        File photo = new File("src/test/resources/image.jpeg"); // adding a file

//        app.getContactsHelper().fillContactForm(new ContactData()
//                .withFirstName(contact.getFirstName())
//                .withLastName(contact.getLastName())
//                .withTitle(contact.getTitle())
//                .withCompany(contact.getCompany())
//                .withAddress(contact.getAddress())
//                .withPhone(contact.getPhone())
//                .withEmail(contact.getEmail())
//                .withCompanyAddress(contact.getCompanyAddress())
//                .withPhoto(photo)
//                .withGroup(contact.getGroup()));

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

    @Test(enabled = false)
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

    @Test(enabled = false)
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
