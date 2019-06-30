package hw3.steps;

import hw3.base.BaseTest;
import hw3.enums.HeaderMenuItem;
import hw3.enums.LeftSideMenuItem;
import hw3.enums.ServiceOption;
import hw3.voids.IndexPage;
import org.openqa.selenium.WebDriver;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPageSteps {

    // TODO Could be extracted to the base class
    private WebDriver driver;

    private IndexPage indexPage;

    public IndexPageSteps(WebDriver driver) {
        this.driver = driver;
        indexPage = new IndexPage(driver);
    }

    // TODO Could be extracted to the base class
    public void login(String name, String password) {
        indexPage.login(name, password);
    }

    public String getUserName() {
        return indexPage.getUserName();
    }

    public void checkItemsOnTheHeaderSectionAreDisplayedAndHaveText(List<String> items) {
        assertEquals(items.size(), indexPage.getHeaderItemsSize());
        assertTrue(indexPage.allHeaderItemsDisplayed());
        List<String> actualHeaderMenuItems = indexPage.getHeaderItemsText();
        checkListsEquals(actualHeaderMenuItems, items);
    }

    public void checkImages(Integer amount) {
        assertTrue(indexPage.areImagesDisplayed());
        assertEquals(amount, indexPage.getImagesAmount());
    }

    public void checkTextUnderImages(Integer amount) {
        assertTrue(indexPage.areImagesTextDisplayed());
        assertEquals(indexPage.getImagesTextAmount(), amount);
    }

    public void checkMainHeadersDisplayedAndHasText(String titleText, String subtitleText) {
        assertTrue(indexPage.isMainTitleDisplayed());
        assertEquals(titleText, indexPage.getMainTitleText());
        assertTrue(indexPage.isMainSubtitleDisplayed());
        assertEquals(subtitleText, indexPage.getMainSubtitleText());
    }

    public boolean isIFrameDisplayed() {
        return indexPage.isIFrameDisplayed();
    }

    public void switchToIFrame() {
        indexPage.switchToIFrame();
    }

    public boolean isLogoDisplayed() {
        return indexPage.isLogoDisplayed();
    }

    public void switchToOriginalWindow() {
        indexPage.switchToDefaultContent();
    }

    public void checkMainLinkDisplayedAndHasText(String linkText) {
        assertTrue(indexPage.isMainLinkDisplayed());
        assertEquals(linkText, indexPage.getMainLinkText());
    }

    public void checkMainLinkHasURL(String url) {
        assertEquals(url, indexPage.getMainLinkURL());
    }

    public boolean isLeftSectionDisplayed() {
        return indexPage.isLeftSectionDisplayed();
    }

    public boolean isFooterDisplayed() {
        return indexPage.isFooterDisplayed();
    }

    public void clickOnHeaderMenuItemAndCheckOptions(HeaderMenuItem headerMenuItem, List<String> options) {
        indexPage.clickOnHeaderMenuItem(headerMenuItem);
        assertTrue(indexPage.isHeaderDropdownDisplayed());
        checkListsEquals(indexPage.getOpenedHeaderDropdownOptionsText(),
                options.stream().map(option -> option.toUpperCase()).collect(Collectors.toList()));
    }

    public void clickOnLeftSectionMenuItemAndCheckOptions(LeftSideMenuItem menuItem, List<String> options) {
        indexPage.clickOnLeftSectionMenuItem(menuItem);
        assertTrue(indexPage.isLeftSideDropdownDisplayed());
        checkListsEquals(indexPage.getOpenedLeftSectionDropdownOptionsText(), options);
    }

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
