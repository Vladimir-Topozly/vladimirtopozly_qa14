package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase {
    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupsPage();

        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup();   // check precondition if group exists
        }

        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void testGroupDeletionByIndex() {
        app.getNavigationHelper().goToGroupsPage();

        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup();   // check precondition if group exists
        }

        List<GroupData> before = app.getGroupHelper().getGroupList();
        // int before = app.getGroupHelper().getGroupCount();

        app.getGroupHelper().selectGroupByIndex(before.size() - 1);
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupsPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();
        //  int after = app.getGroupHelper().getGroupCount();

        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
