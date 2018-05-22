package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test(priority = 2) // priority- defines sequence of the test execution
    public void testGroupCreationLongName() throws Exception {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("myName", "myHeader", "myFooter"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        System.out.println("testGroupCreationLongName() PASSED"); // will print only if the test passed

        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 1, enabled = false) // method won't be executed
    public void testGroupCreationShortName() throws Exception {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("n1", "h1", "f1"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        System.out.println("testGroupCreationShortName() PASSED");

        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 3, enabled = false)  // method won't be executed
    public void testGroupCreationEmpty() throws Exception {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        System.out.println("testGroupCreationEmpty() PASSED");

        Assert.assertEquals(after, before + 1);
    }

}
