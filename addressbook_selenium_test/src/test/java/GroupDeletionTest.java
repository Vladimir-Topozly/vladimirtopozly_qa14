import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{
    @Test
    public void testGroupDeletion (){
        goToGroupsPage();
        selectGroup();
        deleteGroup();
        returnToTheGroupPage();
    }
}
