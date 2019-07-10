package hw6.pages;

import hw6.enums.UserTableElement;
import hw6.enums.UserTableUser;
import hw6.enums.UserTableUserIndex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserTable extends Page {

    private static UserTable instance;

    @FindBy(xpath = "//select")
    private List<WebElement> dropdowns;

    @FindBy(xpath = "//td/a")
    private List<WebElement> userNames;

    @FindBy(css = "#user-table td:first-child")
    private List<WebElement> numbers;

    @FindBy(xpath = "//td//img")
    private List<WebElement> descriptionsImages;

    @FindBy(xpath = "//div[@class='user-descr']//span")
    private List<WebElement> descriptionsTexts;

    @FindBy(xpath = "//td//input")
    private List<WebElement> checkboxes;

    @FindBy(css = "ul.panel-body-list.logs")
    private WebElement logText;

    private UserTable(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getTableElements(UserTableElement element) {
        switch (element) {
            case CHECKBOX:
                return checkboxes;
            case USER_NAME:
                return userNames;
            case DESCRIPTION_TEXT:
                return descriptionsTexts;
            case DESCRIPTION_IMAGE:
                return descriptionsImages;
            case TYPE_DROPDOWN:
                return dropdowns;
            default:
                return null;
        }
    }

    public List<String> getNames() {
        return userNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<Map<String, String>> getEntries() {
        List<Map<String, String>> table = new ArrayList<>();
        for (int i = 0; i < userNames.size(); i++) {
            Map<String, String> row = new HashMap<>();
            row.put("User", userNames.get(i).getText().replaceAll("\n", " "));
            row.put("Description", descriptionsTexts.get(i).getText().replaceAll("\n", " "));
            row.put("Number", numbers.get(i).getText().replaceAll("\n", " "));
            table.add(row);
        }
        return table;
    }

    public void clickVipCheckboxFor(String name) {
        driver.findElement(By.xpath("//input[@id='" + name + "']")).click();
    }

    public String getLogText() {
        return logText.getText();
    }

    public void clickOnDropDown(UserTableUserIndex user) {
        dropdowns.get(user.getIndex()).click();
    }

    public List<WebElement> getDropdowns() {
        return dropdowns;
    }

    public static UserTable getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new UserTable(driver);
        }
        return instance;
    }
}
