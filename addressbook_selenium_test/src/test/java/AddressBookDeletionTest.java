import org.testng.annotations.Test;

public class AddressBookDeletionTest extends AddressBookTestBase {
    @Test
    public void testAddressBookDeletion(){
        goToHomePage();
        selectAddressBook();
        deleteAddressBook();
        returnToHomePage();
    }


}
