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

    @Step("Check interface on Different elements page, it contains all needed elements: '{0}")
    public void checkInterfaceContainsElements(List<ControlType> controlTypes) {
        for (ControlType type : controlTypes) {
            assertTrue(differentElementsPage.isAllElementsOfTypeDisplayed(type));
        }
    }

    @Step("Checking that there is Left Section")
    public boolean isLeftSectionDisplayed() {
        return differentElementsPage.isLeftSectionDisplayed();
    }

    @Step("Checking that there is Right Section")
    public boolean isRightSectionDisplayed() {
        return differentElementsPage.isRightSectionDisplayed();
    }

    @Step("Select checkboxes '{0}' and checking Log row has checkbox name and its status is corresponding to selected")
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

    @Step("Select radiobutton '{0}' and checking Log row has radiobutton name and its status is corresponding to selected")
    public void selectRadioButtonAndCheckLog(RadioItem radioItem) {
        boolean isSelected = differentElementsPage
                .selectControlAndGetState(ControlType.RADIO, radioItem.getName());
        assertTrue(isSelected);
        assertTrue(differentElementsPage.isLogElementsDisplayed());
        assertTrue(differentElementsPage
                .isElementPresentInLogs(radioItem.getName(), ControlType.RADIO, true));
    }

    @Step("Select dropdown '{0}' and checking Log row has dropdown name and its status is corresponding to selected")
    public void selectItemsInDropdownAndCheckLog(DropdownValue dropdownValue) {
        boolean isSelected = differentElementsPage
                .selectControlAndGetState(ControlType.DROPDOWN, dropdownValue.getName());
        assertTrue(isSelected);
        assertTrue(differentElementsPage.isLogElementsDisplayed());
        assertTrue(differentElementsPage
                .isElementPresentInLogs(dropdownValue.getName(), ControlType.RADIO, true));
    }


}
