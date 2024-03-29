package hw3.ex1;

import hw3.base.BaseTest;
import hw3.enums.HeaderMenuItem;
import hw3.steps.IndexPageSteps;
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

        indexPageSteps.checkItemsOnTheHeaderSectionAreDisplayedAndHaveText(Arrays.asList(HeaderMenuItem.HOME.getName(),
                HeaderMenuItem.CONTACT_FORM.getName(), HeaderMenuItem.SERVICE.getName(),
                HeaderMenuItem.METALS_AND_COLORS.getName()));

        indexPageSteps.checkImages(4);

        indexPageSteps.checkTextUnderImages(4);

        indexPageSteps.checkMainHeadersDisplayedAndHasText("EPAM FRAMEWORK WISHES…",
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                        "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS " +
                        "NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR " +
                        "IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        assertTrue(indexPageSteps.isIFrameDisplayed());

        indexPageSteps.switchToIFrame();

        assertTrue(indexPageSteps.isLogoDisplayed());

        indexPageSteps.switchToOriginalWindow();

        indexPageSteps.checkMainLinkDisplayedAndHasText("JDI GITHUB");

        indexPageSteps.checkMainLinkHasURL("https://github.com/epam/JDI");

        assertTrue(indexPageSteps.isLeftSectionDisplayed());

        assertTrue(indexPageSteps.isFooterDisplayed());

    }

}
