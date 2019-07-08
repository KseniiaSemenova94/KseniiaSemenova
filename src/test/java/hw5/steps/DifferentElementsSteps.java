package hw5.steps;

import hw3.enums.CheckboxItem;
import hw3.enums.ControlType;
import hw3.enums.DropdownValue;
import hw3.enums.RadioItem;
import hw5.voids.DifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DifferentElementsSteps {

    private WebDriver driver;

    private DifferentElementsPage differentElementsPage;

    public DifferentElementsSteps(WebDriver driver) {
        this.driver = driver;
        differentElementsPage = new DifferentElementsPage(driver);
    }

    @Step("Check interface on Different elements page, it contains all needed elements")
    public void checkInterfaceContainsElements(List<ControlType> controlTypes) {
        for (ControlType type : controlTypes) {
            assertTrue(differentElementsPage.isAllElementsOfTypeDisplayed(type));
        }
    }

    @Step("Assert that there is Left Section")
    public boolean isLeftSectionDisplayed() {
        return differentElementsPage.isLeftSectionDisplayed();
    }

    @Step("Assert that there is Right Section")
    public boolean isRightSectionDisplayed() {
        return differentElementsPage.isRightSectionDisplayed();
    }

    @Step("Select checkboxes '{0}'")
    public void selectCheckboxesAndCheckLog(List<CheckboxItem> checkboxes, boolean initSelected) {
        for (CheckboxItem checkbox : checkboxes) {
            boolean isSelected = differentElementsPage
                    .selectControlAndGetState(ControlType.CHECKBOX, checkbox.getName());
            if (initSelected) {
                assertFalse(isSelected);
            } else  {
                assertTrue(isSelected);
            }
            assertTrue(differentElementsPage.isLogElementsDisplayed());
            assertTrue(differentElementsPage
                    .isElementPresentInLogs(checkbox.getName(), ControlType.CHECKBOX, initSelected));
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

    public void selectItemsInDropdownAndCheckLog(DropdownValue dropdownValue) {
        boolean isSelected = differentElementsPage
                .selectControlAndGetState(ControlType.DROPDOWN, dropdownValue.getName());
        assertTrue(isSelected);
        assertTrue(differentElementsPage.isLogElementsDisplayed());
        assertTrue(differentElementsPage
                .isElementPresentInLogs(dropdownValue.getName(), ControlType.RADIO, true));
    }


}
