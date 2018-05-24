package com.telran.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver driver) { // constructor for the super class HelperBase
        super(driver);
    }

    public void goToGroupsPage() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }

    public void goToHomePage() {
        if (isElementPresent(By.xpath("//input[@title='Search for any text']"))
                && isElementPresent(By.xpath("//input[@value='Send e-Mail']"))
                && isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }
}
