package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test //(priority = 3) // priority defines sequence of the test execution
    public void testGroupCreationLongName() throws Exception {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();

        app.getGroupHelper().fillGroupForm(new GroupData() // using setters from the GroupData class
                .withName("myName")
                .withHeader("myHeader")
                .withFooter("myFooter"));

        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        System.out.println("method 1 PASSED: testGroupCreationLongName()"); // will be printed only if test passed

        Assert.assertEquals(after, before + 1);
    }

    @Test //(priority = 2) // due to 'enabled = false' method won't be executed
    public void testGroupCreationShortName() throws Exception {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();

        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName("n1")
                .withHeader("h1")
                .withFooter("f1"));

        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        System.out.println("method 2 PASSED: testGroupCreationShortName()");

        Assert.assertEquals(after, before + 1);
    }

    @Test //(priority = 1)  // method won't be executed
    public void testGroupCreationNoName() throws Exception {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();

        app.getGroupHelper().fillGroupForm(new GroupData()); // since we now have a constructor
        // we don't need to use 'null' or empty String as an argument to create an empty group

        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        System.out.println("method 3 PASSED: testGroupCreationNoName()");

        Assert.assertEquals(after, before + 1);
    }

}
