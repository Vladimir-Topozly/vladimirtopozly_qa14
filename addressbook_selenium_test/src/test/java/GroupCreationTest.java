import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase{


    @Test
    public void testGroupCreation() throws Exception {
        openAddressBook();
        login();
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("name", "header", "footer");
        submitGroupCreation();
        returnToTheGroupPage();
    }

}
