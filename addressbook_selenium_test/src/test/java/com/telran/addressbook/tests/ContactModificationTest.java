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
                .withFirstName("EditedName").withLastName("Edited_LastName")
                .withTitle("Edited_long_title_1").withCompany("Edited_company").withCompanyAddress("Edited_Com_address")
                .withPhone("Edited_phone...").withEmail("edited_email@mail.com").withAddress("Edited_address"));
        app.getContactsHelper().submitContactModification();
        app.getContactsHelper().returnToHomePage();
        int after = app.getContactsHelper().GetContactCount();

        Assert.assertEquals(after, before);
    }
}
