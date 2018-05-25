package com.telran.addressbook.tests;

import com.telran.addressbook.appManager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static ApplicationManager app =
            new ApplicationManager(BrowserType.CHROME); // make static in order to create more
    // than one object of the ApplicationManager (to run more than one test)

    @BeforeSuite(alwaysRun = true)    // annotation for the TestNG framework
    public void setUp() {
        app.start();

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }
}
