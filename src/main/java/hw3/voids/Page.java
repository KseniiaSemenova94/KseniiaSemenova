package hw3.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Page {

    private WebDriver driver;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li")
    private List<WebElement> headerItems;



    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String password) {
        userIcon.click();
        loginTextField.sendKeys(userName);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

    public String getUserName() {
        return userName.getText();
    }

    public List<String> getHeaderItemsText() {
        return getItemText(headerItems);
    }

    public List<String> getItemText(List<WebElement> items) {
     return items.stream().map(el -> el.getText()).collect(Collectors.toList());
    }
    public String getItemText(WebElement item) {
       return item.getText();
    }

    public boolean allHeaderItemsDisplayed() {
        return allItemsAreDisplayed(headerItems);
    }

    public int getHeaderItemsSize() {
        return headerItems.size();
    }

    protected boolean allItemsAreDisplayed(List<WebElement> items) {
        return items.stream().allMatch(item -> item.isDisplayed());
    }
}
