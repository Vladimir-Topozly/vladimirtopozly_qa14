import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase{


    @Test(priority = 2)
    public void testGroupCreationLongName() throws Exception {
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("myName", "myHeader", "myFooter");
        submitGroupCreation();
        returnToTheGroupPage();
        System.out.println("testGroupCreationLongName() passed");
    }

    @Test(priority = 1)
    public void testGroupCreationShortName() throws Exception {
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("n1", "h1", "f1");
        submitGroupCreation();
        returnToTheGroupPage();
        System.out.println("testGroupCreationShortName() passed");
    }

    @Test(priority = 3, enabled = false)  //enables method
    public void testGroupCreationEmpty() throws Exception {
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("", "", "");
        submitGroupCreation();
        returnToTheGroupPage();
        System.out.println("testGroupCreationEmpty() passed");
    }

}
