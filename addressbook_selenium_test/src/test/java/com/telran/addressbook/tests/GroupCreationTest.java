package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GroupCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader
                (new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");  // use groups.xml to fill data
            list.add(new Object[]{new GroupData()
                    .withName(split[0])
                    .withHeader(split[1])
                    .withFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }


    @Test(dataProvider = "validGroups", priority = 0) // priority defines sequence of the test execution
    public void testGroupCreationLongName(GroupData group) {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();

        app.getGroupHelper().fillGroupForm(new GroupData() // using setters from the GroupData class and data provider above
                .withName(group.getName())
                .withHeader(group.getHeader())
                .withFooter(group.getFooter()));

        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        System.out.println("method 1 PASSED: testGroupCreationLongName()"); // will be printed only if test passed

        Assert.assertEquals(after, before + 1);
    }

    @Test(priority = 2, enabled = false) // due to 'enabled = false' method won't be executed
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

    @Test(priority = 1, enabled = false)
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
