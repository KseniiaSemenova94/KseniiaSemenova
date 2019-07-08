package hw5.steps;

import hw5.base.BaseTest;
import hw3.enums.HeaderMenuItem;
import hw3.enums.LeftSideMenuItem;
import hw3.enums.ServiceOption;
import hw5.voids.IndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPageSteps {

    private WebDriver driver;

    private IndexPage indexPage;

    public IndexPageSteps(WebDriver driver) {
        this.driver = driver;
        indexPage = new IndexPage(driver);
    }

    @Step("Login as user: {0}")
    public void login(String name, String password) {
        indexPage.login(name, password);
    }

    @Step("Checking that user name is displayed and equals to an expected result")
    public String getUserName() {
        return indexPage.getUserName();
    }

    @Step("Checking that menu buttons are displayed and have proper texts")
    public void checkItemsOnTheHeaderSectionAreDisplayedAndHaveText(List<String> items) {
        assertEquals(items.size(), indexPage.getHeaderItemsSize());
        assertTrue(indexPage.allHeaderItemsDisplayed());
        List<String> actualHeaderMenuItems = indexPage.getHeaderItemsText();
        checkListsEquals(actualHeaderMenuItems, items);
    }

    @Step("Checking that there are '{0}' images on the Index Page and they are displayed")
    public void checkImages(Integer amount) {
        assertTrue(indexPage.areImagesDisplayed());
        assertEquals(amount, indexPage.getImagesAmount());
    }

    @Step("Checking that there are '{0}' texts on the Index Page under images")
    public void checkTextUnderImages(Integer amount) {
        assertTrue(indexPage.areImagesTextDisplayed());
        assertEquals(indexPage.getImagesTextAmount(), amount);
    }

    @Step("Checking that text of the main headers '{0}' and '{1}' equals to an expected results")
    public void checkMainHeadersDisplayedAndHasText(String titleText, String subtitleText) {
        assertTrue(indexPage.isMainTitleDisplayed());
        assertEquals(titleText, indexPage.getMainTitleText());
        assertTrue(indexPage.isMainSubtitleDisplayed());
        assertEquals(subtitleText, indexPage.getMainSubtitleText());
    }

    @Step("Checking that there is the iframe in the center of page")
    public boolean isIFrameDisplayed() {
        return indexPage.isIFrameDisplayed();
    }

    @Step("Switch to the iframe in the center of page")
    public void switchToIFrame() {
        indexPage.switchToIFrame();
    }

    @Step("Checking that there is Epam logo in the left top conner of iframe")
    public boolean isLogoDisplayed() {
        return indexPage.isLogoDisplayed();
    }

    @Step("Switch to original window back")
    public void switchToOriginalWindow() {
        indexPage.switchToDefaultContent();
    }

    @Step("Checking that the text '{0}' of the sub header equals to an expected results")
    public void checkMainLinkDisplayedAndHasText(String linkText) {
        assertTrue(indexPage.isMainLinkDisplayed());
        assertEquals(linkText, indexPage.getMainLinkText());
    }

    @Step("Checking that '{0}' is a link and has a proper URL")
    public void checkMainLinkHasURL(String url) {
        assertEquals(url, indexPage.getMainLinkURL());
    }

    @Step("Checking that there is Left Section")
    public boolean isLeftSectionDisplayed() {
        return indexPage.isLeftSectionDisplayed();
    }

    @Step("Checking that there is Footer")
    public boolean isFooterDisplayed() {
        return indexPage.isFooterDisplayed();
    }

    @Step("Click on '{0}' subcategory in the header and check that drop down contains '{1}'")
    public void clickOnHeaderMenuItemAndCheckOptions(HeaderMenuItem headerMenuItem, List<String> options) {
        indexPage.clickOnHeaderMenuItem(headerMenuItem);
        assertTrue(indexPage.isHeaderDropdownDisplayed());
        checkListsEquals(indexPage.getOpenedHeaderDropdownOptionsText(),
                options.stream().map(option -> option.toUpperCase()).collect(Collectors.toList()));
    }

    @Step("Click on '{0}' subcategory in the left section and check that drop down contains '{1}'")
    public void clickOnLeftSectionMenuItemAndCheckOptions(LeftSideMenuItem menuItem, List<String> options) {
        indexPage.clickOnLeftSectionMenuItem(menuItem);
        assertTrue(indexPage.isLeftSideDropdownDisplayed());
        checkListsEquals(indexPage.getOpenedLeftSectionDropdownOptionsText(), options);
    }

    @Step("Open through the header menu '{0}' and select '{1}'")
    public void openHeaderMenuDropdownAndSelectOption(HeaderMenuItem headerMenuItem, ServiceOption serviceOption) {
        indexPage.clickOnHeaderMenuItem(headerMenuItem);
        indexPage.clickOnHeaderDropdownOption(serviceOption.getName().toUpperCase());
        assertEquals(driver.getCurrentUrl(), BaseTest.DIFFERENT_ELEMENTS_PAGE_URL);
    }

    // TODO Why do you decide use List not List<String>???
    private void checkListsEquals(List actualItems, List expectedItems) {
        assertEquals(actualItems.size(), expectedItems.size());
        Collections.sort(actualItems);
        Collections.sort(expectedItems);
        assertEquals(actualItems, expectedItems);
    }

}
