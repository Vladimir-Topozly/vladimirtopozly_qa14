import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase{


    @Test
    public void testGroupCreationLongName() throws Exception {
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("name", "header", "footer");
        submitGroupCreation();
        returnToTheGroupPage();
    }

    @Test
    public void testGroupCreationShortName() throws Exception {
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("n", "h", "f");
        submitGroupCreation();
        returnToTheGroupPage();
    }

    @Test
    public void testGroupCreationEmpty() throws Exception {
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("", "", "");
        submitGroupCreation();
        returnToTheGroupPage();
    }

}
