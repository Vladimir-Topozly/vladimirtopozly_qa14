package com.tr.example;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{
    @Test
    public void testGroupDeletion (){
        app.goToGroupsPage();
        app.selectGroup();
        app.deleteGroup();
        app.returnToTheGroupPage();
    }
}
