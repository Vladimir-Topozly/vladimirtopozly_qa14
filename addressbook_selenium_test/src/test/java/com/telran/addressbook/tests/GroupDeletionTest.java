package com.telran.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {
    @Test
    public void testGroupDeletion() {
        app.goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);
    }
}
