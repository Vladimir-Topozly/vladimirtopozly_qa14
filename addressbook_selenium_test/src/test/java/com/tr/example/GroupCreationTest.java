package com.tr.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase{


    @Test(priority = 2)
    public void testGroupCreationLongName() throws Exception {
        app.goToGroupsPage();
        int before = app.getGroupCount();
        app.initGroupCreation();
        app.fillGroupForm(new ContactData("myName", "myHeader", "myFooter"));
        app.submitGroupCreation();
        app.returnToTheGroupPage();
        int after = app.getGroupCount();
        Assert.assertEquals(after, before +1); // ?

        System.out.println("testGroupCreationLongName() passed");
    }

    @Test(priority = 1)
    public void testGroupCreationShortName() throws Exception {
        app.goToGroupsPage();
        app.initGroupCreation();
        app.fillGroupForm(new ContactData("n1", "h1", "f1"));
        app.submitGroupCreation();
        app.returnToTheGroupPage();

        System.out.println("testGroupCreationShortName() passed");
    }

    @Test(priority = 3, enabled = false)  //enables method
    public void testGroupCreationEmpty() throws Exception {
        app.goToGroupsPage();
        app.initGroupCreation();
        app.fillGroupForm(new ContactData("", "", ""));
        app.submitGroupCreation();
        app.returnToTheGroupPage();

        System.out.println("testGroupCreationEmpty() passed");
    }

}
