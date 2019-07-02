package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw3.enums.HeaderMenuItem;
import hw3.enums.LeftSideMenuItem;
import hw3.enums.ServiceOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Page {

    @FindBy(id = "user-icon")
    private SelenideElement userIcon;

    @FindBy(id = "name")
    private SelenideElement loginTextField;

    @FindBy(id = "password")
    private SelenideElement passwordTextField;

    @FindBy(id = "login-button")
    private SelenideElement loginButton;

    @FindBy(id = "user-name")
    private SelenideElement userName;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li")
    private ElementsCollection headerMenuItems;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li")
    private ElementsCollection openedHeaderDropdownOptions;

    @FindBy(xpath = "//ul[@class='sidebar-menu']/li")
    private ElementsCollection leftSectionMenuItems;

    @FindBy(xpath = "//ul[@class='sub']/li//a")
    private ElementsCollection openedLeftSectionDropdownOptions;

    @FindBy(id = "mCSB_1")
    private SelenideElement leftSection;


    public void login(String userName, String password) {
        userIcon.click();
        loginTextField.sendKeys(userName);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

    public void clickOnHeaderMenuItem(HeaderMenuItem headerMenuItem) {
        clickOnMenuItem(headerMenuItems, headerMenuItem.getName());
    }

    public void clickOnLeftSectionMenuItem(LeftSideMenuItem menuItem) {
        clickOnMenuItem(leftSectionMenuItems, menuItem.getName());
    }

    public void clickOnHeaderDropdownOption(ServiceOption option) {
        clickOnMenuItem(openedHeaderDropdownOptions, option.getName().toUpperCase());
    }

    public SelenideElement getUserName() {
        return userName;
    }

    public ElementsCollection getOpenedHeaderDropdownOptions() {
        return openedHeaderDropdownOptions;
    }

    public ElementsCollection getOpenedLeftSectionDropdownOptions() {
        return openedLeftSectionDropdownOptions;
    }

    public SelenideElement getLeftSection() {
        return leftSection;
    }

    private void clickOnMenuItem(ElementsCollection menuItems, String name) {
        menuItems.stream().filter(i -> name.equals(i.getText())).findAny()
                .ifPresent(SelenideElement::click);
    }


}
