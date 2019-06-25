package hw2.ex1;

import hw2.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends BaseTest {

    @Test
    public void exercise1Test() {

        // 1. Open test site by URL
        assertEquals(driver.getCurrentUrl(), INDEX_PAGE_URL);

        // 2. Assert Browser title
        assertEquals(driver.getTitle(), BROWSER_HOME_PAGE_TITLE);

        // 3. Perform login
        // 4. Assert User name in the left-top side of screen that user is loggined
        loginTest(USER_LOGIN, USER_PASSWORD, USER_NAME);

        // 5. Assert Browser title
        assertEquals(driver.getTitle(), BROWSER_HOME_PAGE_TITLE);

        // 6. Assert that there are 4 items on the header section are displayed and they have proper texts
        testItemsDisplayed(HEADER_TEXT_ELEMENTS.size(), HEADER_TEXT_LOCATOR);
        testItemsHasText(HEADER_TEXT_ELEMENTS, HEADER_TEXT_LOCATOR);

        // 7. Assert that there are 4 images on the Index Page and they are displayed
        testItemsDisplayed(4, By.className("icons-benefit"));

        // 8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        testItemsDisplayed(UNDER_ICONS_TEXTS.size(), UNDER_ICONS_TEXTS_LOCATOR);
        testItemsHasText(UNDER_ICONS_TEXTS, UNDER_ICONS_TEXTS_LOCATOR);

        // 9. Assert a text of the main headers
        elementDisplayedAndHasText("EPAM FRAMEWORK WISHES…", MAIN_TITLE_LOCATOR);

        elementDisplayedAndHasText("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                        "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS " +
                        "NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR " +
                        "IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.",
                MAIN_SUBTITLE_LOCATOR); //

        // 10. Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());

        // 11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.id("epam_logo")).isDisplayed());

        // 12. Switch to original window back
        driver.switchTo().defaultContent();

        // 13. Assert a text of the sub header
        elementDisplayedAndHasText("JDI GITHUB", JDI_GITHUB_LOCATOR);

        // 14. Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver.findElement(JDI_GITHUB_LOCATOR).getAttribute("href"), "https://github.com/epam/JDI");

        // 15. Assert that there is Left Section
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());

        // 16. Assert that there is Footer
        assertTrue(driver.findElement(By.tagName("footer")).isDisplayed());

    }

}
