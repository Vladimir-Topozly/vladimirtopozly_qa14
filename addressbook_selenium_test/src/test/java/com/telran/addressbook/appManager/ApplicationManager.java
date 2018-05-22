package com.telran.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver driver;
    private GroupHelper groupHelper;
    private ContactsHelper contactsHelper;
    private NavigationHelper navigationHelper;
    private String browser;     // variable to define which browser to use

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void start() {
        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals((BrowserType.FIREFOX))) {
            driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(BrowserType.IE)){ //TODO: add internet explorer driver to /opt/tools
            driver  = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // fluent interface- one methods calls another)
        groupHelper = new GroupHelper(driver);
        contactsHelper = new ContactsHelper(driver);
        navigationHelper = new NavigationHelper(driver);

        openAddressBook("http://localhost/addressbook/edit.php");
        login("admin", "secret");
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

    public void openAddressBook(String url) {
        driver.get(url);
    }

    public void stop() {
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactsHelper getContactsHelper() {
        return contactsHelper;
    }
}
