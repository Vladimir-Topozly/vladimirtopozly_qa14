package com.telran.addressbook.generator;

import com.telran.addressbook.model.ContactData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
 // TODO: 1. create photo edition handler; refactor add(new ContactData() accordingly
// TODO: 2. refactor method save making it applicable to the ContactCreationTest class
public class ContactDataGenerator {
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<ContactData> contacts = generateContact(count);
       save(contacts, file);
    }

    private static List<ContactData> generateContact(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i =0; i < count; i ++){
            contacts.add(new ContactData()
                    .withFirstName(String.format("With_IMAGE__name1 %s", i))
                    .withLastName(String.format("Long_lastName %s", i))
                    .withTitle(String.format("long_title_1 %s", i))
                    .withCompany(String.format("Apple %s", i))
                    .withAddress(String.format("Tel Aviv %s" , i))
                    .withPhone(String.format("0540044040 %s", i))
                    .withEmail(String.format("user1@mail.com %s", i))
                    .withCompanyAddress(String.format("Herzliya %s", i))
                    //.withPhoto(photo)
                    .withGroup(String.format("myName %s")));
        }
        return contacts;
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s; %s; %s \n",
                    contact.getFirstName(), contact.getLastName(), contact.getTitle()));
        }
        writer.close();
    }


}
