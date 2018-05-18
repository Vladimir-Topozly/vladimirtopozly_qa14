package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test(priority = 2)
    public void testGroupCreationLongName() throws Exception {
        app.goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("myName", "myHeader", "myFooter"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        //System.out.println("testGroupCreationLongName() passed"); // will print only if the test passed

        Assert.assertEquals(after, before +1);
    }

    @Test(priority = 1, enabled = false) // method won't working
    public void testGroupCreationShortName() throws Exception {
        app.goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("n1", "h1", "f1"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        System.out.println("testGroupCreationShortName() passed");
        Assert.assertEquals(after, before +1);
    }

    @Test(priority = 3, enabled = false)  // method won't working
    public void testGroupCreationEmpty() throws Exception {
        app.goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        System.out.println("testGroupCreationEmpty() passed");
        Assert.assertEquals(after, before +1);
    }

}
