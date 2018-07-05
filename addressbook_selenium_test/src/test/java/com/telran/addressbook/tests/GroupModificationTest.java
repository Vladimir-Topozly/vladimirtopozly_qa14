package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupsPage();

        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup();   // check precondition whether group exists
        }

        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroupByIndex(before.size() - 1);
        app.getGroupHelper().initGroupModification();

        GroupData group = new GroupData()
                .withId(before.get(before.size() - 1).getId())
                .withName("modified_name")
                .withHeader("modified_header")
                .withFooter("modified_footer");

        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);

        System.out.println("Before: " + before);
        System.out.println("After: " + after);

        Assert.assertEquals(new HashSet(before), new HashSet(after));


    }

}
