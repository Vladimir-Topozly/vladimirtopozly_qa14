package com.telran.addressbook.tests;

import com.telran.addressbook.appManager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true)      //an annotation for TestHG framework
    public void setUp() {
        app.start();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

}
