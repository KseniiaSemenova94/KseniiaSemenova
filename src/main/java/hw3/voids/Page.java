package hw3.voids;

import hw3.enums.LeftSideMenuItem;
import hw3.enums.HeaderMenuItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Page {

    WebDriver driver;

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

    @FindBy(id = "mCSB_1")
    private WebElement leftSection;

    @FindBy(tagName = "footer")
    private WebElement footer;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li")
    private List<WebElement> headerMenuItems;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li")
    private List<WebElement> openedHeaderDropdownOptions;

    @FindBy(xpath = "//ul[@class='sub']/li//a")
    private List<WebElement> openedLeftSectionDropdownOptions;

    @FindBy(className = "dropdown-menu")
    private WebElement headerDropdown;

    @FindBy(className = "sub")
    private WebElement leftSectionDropdown;

    @FindBy(xpath = "//ul[@class='sidebar-menu']/li")
    private List<WebElement> leftSectionMenuItems;

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

    public boolean isLeftSectionDisplayed() { return leftSection.isDisplayed(); }

    public boolean isFooterDisplayed() { return footer.isDisplayed(); }

    public void clickOnHeaderMenuItem(HeaderMenuItem headerMenuItem) {
        clickOnMenuItem(headerMenuItems, headerMenuItem.getName());
    }

    public void clickOnHeaderDropdownOption(String option) {
        clickOnMenuItem(openedHeaderDropdownOptions, option);
    }

    public void clickOnLeftSectionMenuItem(LeftSideMenuItem menuItem) {
        clickOnMenuItem(leftSectionMenuItems, menuItem.getName());
    }

    public List<String> getOpenedHeaderDropdownOptionsText() {
        return getItemText(openedHeaderDropdownOptions);
    }

    public List<String> getOpenedLeftSectionDropdownOptionsText() {
        return getItemText(openedLeftSectionDropdownOptions);
    }

    public boolean isHeaderDropdownDisplayed() {
        return headerDropdown.isDisplayed();
    }

    public boolean isLeftSideDropdownDisplayed() {
        return leftSectionDropdown.isDisplayed();
    }

    protected boolean allItemsAreDisplayed(List<WebElement> items) {
        return items.stream().allMatch(item -> item.isDisplayed());
    }

    private void clickOnMenuItem(List<WebElement> menuItems, String name) {
        menuItems.stream().filter(i -> name.equals(i.getText())).findAny()
                .ifPresent(WebElement::click);
    }
}
