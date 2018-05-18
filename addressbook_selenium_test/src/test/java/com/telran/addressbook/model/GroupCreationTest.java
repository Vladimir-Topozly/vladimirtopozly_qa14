package com.telran.addressbook.model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test(priority = 2)
    public void testGroupCreationLongName() throws Exception {
        app.goToGroupsPage();
        int before = app.getGroupCount();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("myName", "myHeader", "myFooter"));
        app.submitGroupCreation();
        app.returnToGroupsPage();
        int after = app.getGroupCount();
        //System.out.println("testGroupCreationLongName() passed"); // will print only if the test passed

        Assert.assertEquals(after, before +1);
    }

    @Test(priority = 1, enabled = false) // method won't working
    public void testGroupCreationShortName() throws Exception {
        app.goToGroupsPage();
        int before = app.getGroupCount();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("n1", "h1", "f1"));
        app.submitGroupCreation();
        app.returnToGroupsPage();
        int after = app.getGroupCount();
        System.out.println("testGroupCreationShortName() passed");
        Assert.assertEquals(after, before +1);
    }

    @Test(priority = 3, enabled = false)  // method won't working
    public void testGroupCreationEmpty() throws Exception {
        app.goToGroupsPage();
        int before = app.getGroupCount();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("", "", ""));
        app.submitGroupCreation();
        app.returnToGroupsPage();
        int after = app.getGroupCount();
        System.out.println("testGroupCreationEmpty() passed");
        Assert.assertEquals(after, before +1);
    }

}
