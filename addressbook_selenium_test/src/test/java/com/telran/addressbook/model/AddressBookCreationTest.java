package com.telran.addressbook.model;

import org.testng.annotations.Test;

public class AddressBookCreationTest extends TestBase {

    @Test(priority = 3)
    public void testAddressBookCreationLongName() {
        app.initAddressBookCreation();
        app.fillAddressBook("Long_name", "Long_lastname", "long_title_1",
                "Apple", "Herzliya", "0540044040",
                "user1@mail.com", "Tel Aviv");
        app.submitAddressBookCreation();
        app.returnToHomePage();
        System.out.println("testAddressBookCreationLongName() passed");
    }

    @Test(priority = 2, enabled = false)
    public void testAddressBookCreationShortName() {
        app.initAddressBookCreation();
        app.fillAddressBook("name", "lastname", "title1",
                "A", "H", "054...",
                "user1@mail.com", "TA");
        app.submitAddressBookCreation();
        app.returnToHomePage();
        System.out.println("testAddressBookCreationShortName() passed");
    }

    @Test(priority = 1, enabled = false)
    public void testAddressBookCreationEmpty() {
        app.initAddressBookCreation();
        app.fillAddressBook("", "", "",
                "", "", "",
                "", "");
        app.submitAddressBookCreation();
        app.returnToHomePage();
        System.out.println("testAddressBookCreationEmpty() passed");
    }

}
