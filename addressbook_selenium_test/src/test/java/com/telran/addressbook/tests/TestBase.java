package com.telran.addressbook.tests;

import com.telran.addressbook.appManager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(); // make static in order to create more
                                                                        // than one object of the ApplicationManager

    @BeforeSuite(alwaysRun = true)      //an annotation for TestNG framework
    public void setUp() {
        app.start();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

}
