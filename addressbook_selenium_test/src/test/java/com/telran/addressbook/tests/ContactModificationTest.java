package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().selectContact();
        app.getContactsHelper().initContactModification();
        app.getContactsHelper().fillContactForm(
                new ContactData("EditedName", "EditedLastname", "Edited_long_title_1",
                        "Edited_company", "Edited_city", "Edited_phone",
                        "Edited_email", "Edited_Address"));
        app.getContactsHelper().submitContactModification();
        app.getContactsHelper().returnToHomePage();
        int after = app.getContactsHelper().GetContactCount();

        Assert.assertEquals(after, before);
    }
}
