import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true) //an annotation for TestHG framework
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        openAddressBook();
        login();
    }

    public void returnToTheGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(String name, String header, String footer) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(name);

        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(header);

        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(footer);
    }

    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void goToGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void login() {
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }


    public void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void deleteGroup() {
        driver.findElement(By.name("delete")).click();
    }

    public void returnToHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }

    public void submitAddressBookCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillAddressBook(String test_name, String test_lastname, String test_title_1, String company,
                                String company_address, String phone, String email, String address) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(test_name);
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(test_lastname);
        driver.findElement(By.name("title")).click();
        driver.findElement(By.name("title")).clear();
        driver.findElement(By.name("title")).sendKeys(test_title_1);
        driver.findElement(By.name("company")).click();
        driver.findElement(By.name("company")).clear();
        driver.findElement(By.name("company")).sendKeys(company);
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(company_address);
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(phone);
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(email);
        driver.findElement(By.name("address2")).click();
        driver.findElement(By.name("address2")).clear();
        driver.findElement(By.name("address2")).sendKeys(address);
    }

    public void addNewAddressBook() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void selectAddressBook() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void editAddressBook() {
        driver.findElement(By.xpath("//img[@alt='Edit']")).click();
    }

    public void updateChangesAddressBook() {
        driver.findElement(By.xpath("(//input[@name='update'])[2]")).click();
    }

//TODO:
    public void deleteAddressBook() {
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        driver.switchTo().alert().accept();
        //driver.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void openAddressBook() {
        driver.get("http://localhost/addressbook/edit.php");
    }

    public void goToHomePage() {
        driver.findElement(By.linkText("home")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
