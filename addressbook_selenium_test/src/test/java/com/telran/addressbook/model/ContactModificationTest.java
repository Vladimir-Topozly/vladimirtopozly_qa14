package com.telran.addressbook.model;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test
    public void testAddressBookModify() {
        app.goToHomePage();
        app.selectContact();
        app.initContactModification();
        app.fillContact(
                new ContactData("EditedName", "EditedLastname", "Edited_long_title_1",
                        "Edited_company", "Edited_city", "Edited_phone",
                        "Edited_email", "Edited_Address"));
        app.submitContactModification();
        app.returnToHomePage();
    }
}
