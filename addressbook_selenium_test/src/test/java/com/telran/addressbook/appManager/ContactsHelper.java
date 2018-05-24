package com.telran.addressbook.appManager;

import com.telran.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(WebDriver driver) { // constructor for the super class HelperBase
        super(driver);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getCompanyAddress());
        type(By.name("mobile"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());
        type(By.name("address2"), contactData.getAddress());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public int GetContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact() {
        initContactCreation();
        fillContactForm(new ContactData()
                .withFirstName("name").withLastName("lastname")
                .withTitle("title1").withCompany("A").withAddress("TA")
                .withPhone("11111111").withEmail("u1@mail.com").withCompanyAddress("H"));
        submitContactCreation();
        returnToHomePage();

    }
}
