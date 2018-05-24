package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();

        if(!app.getContactsHelper().isThereAContact()){
            app.getContactsHelper().createContact();
        }

        int before = app.getContactsHelper().GetContactCount();
        app.getContactsHelper().selectContact();
        app.getContactsHelper().initContactModification();
        app.getContactsHelper().fillContactForm(new ContactData()
                .setFirstName("EditedName").setLastName("Edited_LastName")
                .setTitle("Edited_long_title_1").setCompany("Edited_company").setCompanyAddress("Edited_Com_address")
                .setPhone("Edited_phone...").setEmail("edited_email@mail.com").setAddress("Edited_address"));
        app.getContactsHelper().submitContactModification();
        app.getContactsHelper().returnToHomePage();
        int after = app.getContactsHelper().GetContactCount();

        Assert.assertEquals(after, before);
    }
}
