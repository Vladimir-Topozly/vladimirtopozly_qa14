import org.testng.annotations.Test;

public class AddressBookCreationTest extends TestBase {

    @Test(priority = 3)
    public void testAddressBookCreationLongName() {
        addNewAddressBook();
        fillAddressBook("Long_name", "Long_lastname", "long_title_1",
                "Apple", "Herzliya", "0540044040",
                "user1@mail.com", "Tel Aviv");
        submitAddressBookCreation();
        returnToHomePage();
        System.out.println("testAddressBookCreationLongName() passed");
    }
    @Test(priority = 2)
    public void testAddressBookCreationShortName() {
        addNewAddressBook();
        fillAddressBook("name", "lastname", "title1",
                "A", "H", "054...",
                "user1@mail.com", "TA");
        submitAddressBookCreation();
        returnToHomePage();
        System.out.println("testAddressBookCreationShortName() passed");
    }
    @Test(priority = 1, enabled = true)
    public void testAddressBookCreationEmpty() {
        addNewAddressBook();
        fillAddressBook("", "", "",
                "", "", "",
                "", "");
        submitAddressBookCreation();
        returnToHomePage();
        System.out.println("testAddressBookCreationEmpty() passed");
    }

}
