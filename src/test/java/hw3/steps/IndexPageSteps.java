package hw3.steps;

import hw3.voids.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class IndexPageSteps extends PageSteps {

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
        List<WebElement> headerItems = indexPage.getHeaderItems();
        assertEquals(items.size(), headerItems.size());
        checkItemsAreDisplayed(headerItems);
        checkItemsHaveText(items, headerItems);
    }
}
