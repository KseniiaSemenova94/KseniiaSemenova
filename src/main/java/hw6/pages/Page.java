package hw6.pages;

import hw3.enums.HeaderMenuItem;
import hw3.enums.LeftSideMenuItem;
import hw6.enums.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Page {

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

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(xpath = "//ul[@class='sidebar-menu']/li")
    private List<WebElement> leftSectionMenuItems;

    @FindBy(xpath = "//ul[@class='sub']/li//a")
    private List<WebElement> openedLeftSectionDropdownOptions;

    @FindBy(id = "mCSB_1")
    private WebElement leftSection;

    @FindBy(name = "log-sidebar")
    WebElement rightSection;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract List<WebElement> getTableElements(Element element);

    public void login(String userName, String password) {
        userIcon.click();
        loginTextField.sendKeys(userName);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

    public void clickOnHeaderMenuItem(HeaderMenuItem headerMenuItem) {
        clickOnMenuItem(headerMenuItems, headerMenuItem.getName());
    }

    public void clickOnLeftSectionMenuItem(LeftSideMenuItem leftSideMenuItem) {
        clickOnMenuItem(leftSectionMenuItems, leftSideMenuItem.getName());
    }

    public void clickOnHeaderDropdownOption(String option) {
        clickOnMenuItem(openedHeaderDropdownOptions, option);
    }

    public boolean isUserNameDisplayed() {
        return userName.isDisplayed();
    }

    public String getUserNameText() {
        return userName.getText();
    }

    public List<String> getOpenedHeaderDropdownOptions() {
        return openedHeaderDropdownOptions.stream().map(el -> el.getText()).collect(Collectors.toList());
    }

    public List<String> getOpenedLeftSectionDropdownOptions() {
        return openedLeftSectionDropdownOptions.stream().map(el -> el.getText()).collect(Collectors.toList());
    }

    public boolean isLeftSectionDisplayed() { return leftSection.isDisplayed(); }

    public boolean isRightSectionDisplayed() {
        return rightSection.isDisplayed();
    }

    private void clickOnMenuItem(List<WebElement> menuItems, String name) {
        menuItems.stream().filter(i -> name.equals(i.getText())).findAny()
                .ifPresent(WebElement::click);
    }

}
