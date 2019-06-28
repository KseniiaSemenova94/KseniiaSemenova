package hw3.steps;

import hw3.enums.CheckboxItem;
import hw3.enums.ControlType;
import hw3.enums.RadioItem;
import hw3.voids.DifferentElementsPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class DifferentElementsSteps {

    private WebDriver driver;

    private DifferentElementsPage differentElementsPage;

    public DifferentElementsSteps(WebDriver driver) {
        this.driver = driver;
        differentElementsPage = new DifferentElementsPage(driver);
    }

    public void checkInterfaceContainsElements(List<ControlType> controlTypes) {
        for (ControlType type : controlTypes) {
            assertTrue(differentElementsPage.isAllElementsOfTypeDisplayed(type));
        }
    }

    public boolean isLeftSectionDisplayed() {
        return differentElementsPage.isLeftSectionDisplayed();
    }

    public boolean isRightSectionDisplayed() {
        return differentElementsPage.isRightSectionDisplayed();
    }

    public void selectCheckboxesAndCheckLog(List<CheckboxItem> checkboxes) {
        for (CheckboxItem checkbox : checkboxes) {
            boolean isSelected = differentElementsPage
                    .selectControlAndGetState(ControlType.CHECKBOX, checkbox.getName());
            assertTrue(isSelected);
            assertTrue(differentElementsPage.isLogElementsDisplayed());
            assertTrue(differentElementsPage
                    .isElementPresentInLogs(checkbox.getName(), ControlType.CHECKBOX, true));
        }
    }

    public void selectRadioButtonAndCheckLog(RadioItem radioItem) {
        boolean isSelected = differentElementsPage
                .selectControlAndGetState(ControlType.RADIO, radioItem.getName());
        assertTrue(isSelected);
        assertTrue(differentElementsPage.isLogElementsDisplayed());
        assertTrue(differentElementsPage
                .isElementPresentInLogs(radioItem.getName(), ControlType.RADIO, true));
    }


}
