package hw3.ex1;

import hw3.base.BaseTest;
import hw3.steps.IndexPageSteps;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends BaseTest {

    IndexPageSteps indexPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        indexPageSteps = new IndexPageSteps(driver);
    }

    @Test
    public void exercise1Test() {

        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/index.html");

        assertEquals(driver.getTitle(), "Home Page");

        indexPageSteps.login("epam", "1234");

        assertEquals(indexPageSteps.getUserName(), "PITER CHAILOVSKII");

        assertEquals(driver.getTitle(), "Home Page");

        indexPageSteps.checkItemsOnTheHeaderSectionAreDisplayedAndHaveText(Arrays.asList("HOME", "CONTACT FORM", "SERVICE",
                "METALS & COLORS"));

        // 7. Assert that there are 4 images on the Index Page and they are displayed
//        testItemsDisplayed(4, By.className("icons-benefit"));

        // 8. Assert that there are 4 texts on the Index Page under icons and they have proper text
//        testItemsDisplayed(UNDER_ICONS_TEXTS.size(), UNDER_ICONS_TEXTS_LOCATOR);
//        testItemsHasText(UNDER_ICONS_TEXTS, UNDER_ICONS_TEXTS_LOCATOR);

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
