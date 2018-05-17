package com.telran.addressbook.model;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true)      //an annotation for TestHG framework
    public void setUp() {
        app.start();
        app.openAddressBook("http://localhost/addressbook/edit.php");
        app.login("admin", "secret");
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

}
