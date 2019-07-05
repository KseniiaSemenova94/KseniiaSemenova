package hw5.ex2;

import hw3.enums.HeaderMenuItem;
import hw5.AllureAttachmentListener;
import hw5.base.BaseTest;
import hw5.steps.IndexPageSteps;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(AllureAttachmentListener.class)
public class FailExercise1 extends BaseTest {

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

        getTitle("Home Page");

        indexPageSteps.login("epam", "1234");

        assertEquals(indexPageSteps.getUserName(), "PITER CHAILOVSKII1");

        getTitle("Home Page");

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

    @Step("Browser title equals '{0}'")
    public void getTitle(String expectedTitle){
        assertEquals(driver.getTitle(), expectedTitle);
    }
}
