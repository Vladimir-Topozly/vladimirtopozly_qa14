import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstClass {
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test(enabled = false)  // disable this testCase
  public void searchWebDriverInChrome() throws Exception {
    driver.get("https://www.google.com/");
    driver.findElement(By.id("lst-ib")).click();
    driver.findElement(By.id("lst-ib")).clear();
    driver.findElement(By.id("lst-ib")).sendKeys("webDriver");
    driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
  }

  @Test
  public void elementsTest(){
    driver.get("https://www.google.com/");
    //WebElement settings =
            //driver.findElement(By.id("fsettl")).click();
    driver.findElement(By.xpath("//*[@id='fsettl']")).click(); // the same but via xpath
    
    driver.navigate().refresh();
    driver.findElement(By.id("fsettl")).click();
    //settings.click();

    // alert for HW addressBook:
    //driver.switchTo().alert().accept();
    //driver.switchTo().alert().dismiss();
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
