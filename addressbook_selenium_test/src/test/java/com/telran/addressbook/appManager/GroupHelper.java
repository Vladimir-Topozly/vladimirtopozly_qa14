package com.telran.addressbook.appManager;

import com.telran.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
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
        fillGroupForm(new GroupData()
                .withName("myName")
                .withHeader("myHeader")
                .withFooter("myFooter"));
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void selectGroupByIndex(int index) {
        driver.findElements(By.name("selected[]")).get(index).click(); //click on a specified index
    }

    public List<GroupData> getGroupList() {  // adding all groups on the page into the array
        List<GroupData> groups = new ArrayList<>();

        List<WebElement> elements =
                driver.findElements(By.cssSelector("span.group"));

        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input"))
                    .getAttribute("value"));

            GroupData group = new GroupData().withId(id).withName(name);
            groups.add(group);
        }
        return groups;
    }
}
