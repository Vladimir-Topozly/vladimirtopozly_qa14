package com.telran.addressbook.model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {
    @Test
    public void testGroupDeletion() {
        app.goToGroupsPage();
        int before = app.getGroupCount();
        app.selectGroup();
        app.deleteGroup();
        app.returnToGroupsPage();
        int after = app.getGroupCount();
        Assert.assertEquals(after, before - 1);
    }
}
