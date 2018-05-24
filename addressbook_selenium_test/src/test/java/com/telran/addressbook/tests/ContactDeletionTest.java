package com.telran.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactsHelper().GetContactCount();

        app.getContactsHelper().selectContact();
        app.getContactsHelper().deleteContact();
        app.getContactsHelper().acceptAlert();
        app.getNavigationHelper().goToHomePage();
        int after = app.getContactsHelper().GetContactCount();

        Assert.assertEquals(after, before-1);
    }


}
