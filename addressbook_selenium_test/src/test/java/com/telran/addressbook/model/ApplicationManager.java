package com.telran.addressbook.model;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver driver;

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void returnToGroupsPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(CroupData croup) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(croup.getName());

        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(croup.getHeader());

        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(croup.getFooter());
    }

    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void goToGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void login(String user, String pwd) {
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(user);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void deleteGroup() {
        driver.findElement(By.name("delete")).click();
    }

    public void returnToHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }

    public void submitAddressBookCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillAddressBook(String test_name, String test_lastname, String test_title_1, String company,
                                String company_address, String phone, String email, String address) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(test_name);
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(test_lastname);
        driver.findElement(By.name("title")).click();
        driver.findElement(By.name("title")).clear();
        driver.findElement(By.name("title")).sendKeys(test_title_1);
        driver.findElement(By.name("company")).click();
        driver.findElement(By.name("company")).clear();
        driver.findElement(By.name("company")).sendKeys(company);
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(company_address);
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(phone);
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(email);
        driver.findElement(By.name("address2")).click();
        driver.findElement(By.name("address2")).clear();
        driver.findElement(By.name("address2")).sendKeys(address);
    }

    public void initAddressBookCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void selectAddressBook() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void initAddressBookModification() {
        driver.findElement(By.xpath("//img[@alt='Edit']")).click();
    }

    public void submitAddressBookModification() {
        driver.findElement(By.xpath("(//input[@name='update'])[2]")).click();
    }

    public void deleteAddressBook() {
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void openAddressBook(String url) {
        driver.get(url);
    }

    public void goToHomePage() {
        driver.findElement(By.linkText("home")).click();
    }

    public void stop() {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void initGroupModification() {
        driver.findElement(By.xpath("(//input[@name='edit'])[2]")).click();
    }

    public void submitGroupModification() {
        driver.findElement(By.cssSelector("[name=update]")).click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept(); // To click on the 'OK' button of the alert
    }
}
