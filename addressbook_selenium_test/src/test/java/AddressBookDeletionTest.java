import org.testng.annotations.Test;

public class AddressBookDeletionTest extends TestBase {
    @Test
    public void testAddressBookDeletion() {
        goToHomePage();
        selectAddressBook();
        deleteAddressBook();
        goToHomePage();
    }


}
