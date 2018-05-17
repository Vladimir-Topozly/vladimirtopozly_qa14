package com.telran.addressbook.model;

import org.testng.annotations.Test;

public class AddressBookDeletionTest extends TestBase {
    @Test
    public void testAddressBookDeletion() {
        app.goToHomePage();
        app.selectAddressBook();
        app.deleteAddressBook();
        app.acceptAlert();
        app.goToHomePage();
    }


}
