package appManager;

import model.EventData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) { // constructor for the super class HelperBase
        super(driver);
    }

    public void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(EventData eventData) {
        type(By.name("group_name"), eventData.getName());
        type(By.name("group_header"), eventData.getHeader());
        type(By.name("group_footer"), eventData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void initGroupModification() {
        click(By.xpath("(//input[@name='edit'])[2]"));
    }

    public void submitGroupModification() {
        click(By.cssSelector("[name=update]"));
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createGroup() {
        initGroupCreation();
        fillGroupForm(new EventData()
                .withName("myName")
                .withHeader("myHeader")
                .withFooter("myFooter"));
        submitGroupCreation();
        returnToGroupsPage();
    }
}
