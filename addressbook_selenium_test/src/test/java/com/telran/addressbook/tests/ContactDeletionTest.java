package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactDeletionTest extends TestBase {
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();

        if (!app.getContactsHelper().isThereAContact()) {
            app.getContactsHelper().createContact();
        }

        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().selectContact();
        app.getContactsHelper().deleteContact();
        app.getContactsHelper().acceptAlert();
        app.getNavigationHelper().goToHomePage();
        int after = app.getContactsHelper().GetContactCount();

        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void testContactDeletionByIndex() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactsHelper().isThereAContact()) {
            app.getContactsHelper().createContact();
        }
        List<ContactData> before = app.getContactsHelper().getContactList();
        app.getContactsHelper().selectContactByIndex(before.size() - 1);
        app.getContactsHelper().deleteContact();
        app.getContactsHelper().acceptAlert();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactsHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);

        //Assert.assertEquals(new HashSet(before), new HashSet(after)); //TODO: fix it so as it works as it should

        System.out.println("Before: " + before);
        System.out.println("After: " + after);
    }


}
