import org.testng.annotations.Test;

public class AddressBookModificationTest extends TestBase{

    @Test
    public void testAddressBookModify() {
        goToHomePage();
        selectAddressBook();
        editAddressBook();
        fillAddressBook("EditedName", "EditedLastname", "Edited_long_title_1",
                "Edited_company", "Edited_city", "Edited_phone",
                "Edited_email", "Edited_Address");
        updateChangesAddressBook();
        returnToHomePage();
    }
}
