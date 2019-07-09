package hw6.pages;

import hw3.enums.HeaderMenuItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Page {

    protected WebDriver driver;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li")
    private List<WebElement> headerMenuItems;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li")
    private List<WebElement> openedHeaderDropdownOptions;

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

    public void clickOnHeaderMenuItem(HeaderMenuItem headerMenuItem) {
        clickOnMenuItem(headerMenuItems, headerMenuItem.getName());
    }

    public void clickOnHeaderDropdownOption(String option) {
        clickOnMenuItem(openedHeaderDropdownOptions, option);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    private void clickOnMenuItem(List<WebElement> menuItems, String name) {
        menuItems.stream().filter(i -> name.equals(i.getText())).findAny()
                .ifPresent(WebElement::click);
    }
}
