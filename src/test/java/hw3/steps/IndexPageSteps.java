package hw3.steps;

import hw3.voids.IndexPage;
import org.openqa.selenium.WebDriver;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPageSteps {

    private WebDriver driver;

    private IndexPage indexPage;

    public IndexPageSteps(WebDriver driver) {
        this.driver = driver;
        indexPage = new IndexPage(driver);
    }

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
        assertEquals(actualHeaderMenuItems.size(), items.size());
        Collections.sort(actualHeaderMenuItems);
        Collections.sort(items);
        assertEquals(actualHeaderMenuItems, items);
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
}
