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

        app.getGroupHelper().fillGroupForm(new GroupData() // using set methods from the GroupData class
                .withName("myName")
                .withHeader("myHeader")
                .withFooter("myFooter"));

        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        System.out.println("testGroupCreationLongName() PASSED"); // will be printed only if test passed

        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 1, enabled = false) // method won't be executed
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
        System.out.println("testGroupCreationShortName() PASSED");

        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 3, enabled = false)  // method won't be executed
    public void testGroupCreationEmpty() throws Exception {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData()); // since we now have constructor we don't
        app.getGroupHelper().submitGroupCreation();          // need to use null or empty String as an argument
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        System.out.println("testGroupCreationEmpty() PASSED");

        Assert.assertEquals(after, before + 1);
    }

}
