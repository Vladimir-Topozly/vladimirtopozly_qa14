import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityInTestNG {
    WebDriver driver;

    // Method 1: Open Browser say Firefox
    @Test (priority=1)
    public void openBrowser() {
        //driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        driver = new ChromeDriver();
    }

    // Method 2: Launch Google.com
    @Test (priority=2)
    public void launchGoogle() {
        driver.get("https://www.google.com/?gl=us&hl=en&pws=0&gws_rd=cr");
        //driver.switchTo().alert().dismiss();
    }

    // Method 3: Perform a search using "Facebook"
    @Test (priority=3)
    public void performSearchAndClick1stLink() {
        driver.findElement(By.xpath(".//*[@title='Search']")).sendKeys("Facebook");
        driver.findElement(By.xpath(".//input[@value='Google Search']")).click();
    }

    // Method 4: Verify Google search page title.
    @Test (priority=4)
    public void FaceBookPageTitleVerification() throws Exception {
        Thread.sleep(3000);
       Assert.assertEquals(driver.getTitle().contains("Facebook - Google Search"), true);
    }
}
