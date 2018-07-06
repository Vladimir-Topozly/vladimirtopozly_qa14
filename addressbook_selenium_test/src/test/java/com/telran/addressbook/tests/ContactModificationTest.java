package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactsHelper().isThereAContact()) {
            app.getContactsHelper().createContact();
        }
        File photoModified = new File("src/test/resources/littleGroot.jpg");
        List<ContactData> before = app.getContactsHelper().getContactList();
        app.getContactsHelper().selectContactByIndex(before.size() - 1);
        app.getContactsHelper().initContactModification();

        ContactData contact = new ContactData()
                .withContactID(before.get(before.size() - 1).getContactId())
                .withFirstName("EditedName_With_IMAGE")
                .withLastName("Edited_LastName")
                .withTitle("Edited_long_title_1")
                .withCompany("Edited_company")
                .withCompanyAddress("Edited_Com_address")
                .withPhone("Edited_phone...")
                .withEmail("edited_email@mail.com")
                .withAddress("Edited_address")
                .withPhoto(photoModified)
                .withGroup("testName 4");
        app.getContactsHelper().fillContactForm(contact);
        app.getContactsHelper().submitContactModification();
        app.getContactsHelper().returnToHomePage();
        List<ContactData> after = app.getContactsHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);

        System.out.println("Before: " + before);
        System.out.println("After: " + after);
        //Assert.assertEquals(new HashSet(before), new HashSet(after));//TODO: fix it so as it works as it should
    }
}
