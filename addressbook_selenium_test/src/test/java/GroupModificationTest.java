import com.telran.addressbook.model.GroupData;
import com.telran.addressbook.model.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification(){
        app.goToGroupsPage();
        int before = app.getGroupCount();
        app.selectGroup();
        app.initGroupModification();
        app.fillGroupForm(new GroupData("modified_name", "modified_header", "modified_footer"));
        app.submitGroupModification();
        app.returnToGroupsPage();
        int after = app.getGroupCount();
        Assert.assertEquals(after, before);
    }

}
