package com.tr.example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true) //an annotation for TestHG framework
    public void setUp(){
        app.start();
        app.openAddressBook();
        app.login();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }

}
