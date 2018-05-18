package com.telran.addressbook.model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {
    @Test
    public void testContactDeletion() {
        app.goToHomePage();
        int before = app.GetContactCount();
        app.selectContact();
        app.deleteContact();
        app.acceptAlert();
        app.goToHomePage();
        int after = app.GetContactCount();

        Assert.assertEquals(after, before-1);
    }


}
