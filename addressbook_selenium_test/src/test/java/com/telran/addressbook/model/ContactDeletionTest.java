package com.telran.addressbook.model;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {
    @Test
    public void testAddressBookDeletion() {
        app.goToHomePage();
        app.selectContact();
        app.deleteContact();
        app.acceptAlert();
        app.goToHomePage();
    }


}
