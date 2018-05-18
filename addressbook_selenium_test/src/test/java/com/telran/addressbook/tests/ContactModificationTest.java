package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        app.goToHomePage();
        int before = app.GetContactCount();
        app.selectContact();
        app.initContactModification();
        app.fillContact(
                new ContactData("EditedName", "EditedLastname", "Edited_long_title_1",
                        "Edited_company", "Edited_city", "Edited_phone",
                        "Edited_email", "Edited_Address"));
        app.submitContactModification();
        app.returnToHomePage();
        int after = app.GetContactCount();

        Assert.assertEquals(after, before);
    }
}
