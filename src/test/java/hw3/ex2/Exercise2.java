package hw3.ex2;

import hw3.base.BaseTest;
import hw3.enums.*;
import hw3.steps.DifferentElementsSteps;
import hw3.steps.IndexPageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise2 extends BaseTest {

    public static final List<String> SERVICE_OPTIONS_LIST = Arrays.asList(ServiceOption.SUPPORT.getName(), ServiceOption.DATES.getName(),
            ServiceOption.SEARCH.getName(), ServiceOption.COMPLEX_TABLE.getName(),
            ServiceOption.SIMPLE_TABLE.getName(), ServiceOption.USER_TABLE.getName(),
            ServiceOption.TABLE_WITH_PAGES.getName(), ServiceOption.DIFFERENT_ELEMENTS.getName(),
            ServiceOption.PERFORMANCE.getName());

    IndexPageSteps indexPageSteps;

    DifferentElementsSteps differentElementsSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        indexPageSteps = new IndexPageSteps(driver);
        differentElementsSteps = new DifferentElementsSteps(driver);
    }

    @Test
    public void exercise2Test() {

        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/index.html");

        assertEquals(driver.getTitle(), "Home Page");

        indexPageSteps.login("epam", "1234");

        assertEquals(indexPageSteps.getUserName(), "PITER CHAILOVSKII");

        indexPageSteps.clickOnHeaderMenuItemAndCheckOptions(HeaderMenuItem.SERVICE, SERVICE_OPTIONS_LIST);

        indexPageSteps.clickOnLeftSectionMenuItemAndCheckOptions(LeftSideMenuItem.SERVICE, SERVICE_OPTIONS_LIST);

        indexPageSteps.openHeaderMenuDropdownAndSelectOption(HeaderMenuItem.SERVICE, ServiceOption.DIFFERENT_ELEMENTS);

        differentElementsSteps.checkInterfaceContainsElements(Arrays
                .asList(ControlType.BUTTON, ControlType.CHECKBOX, ControlType.RADIO, ControlType.DROPDOWN));

        assertTrue(differentElementsSteps.isRightSectionDisplayed());

        assertTrue(differentElementsSteps.isLeftSectionDisplayed());

        differentElementsSteps.selectCheckboxesAndCheckLog(Arrays.asList(CheckboxItem.WATER, CheckboxItem.WIND));

        differentElementsSteps.selectRadioButtonAndCheckLog(RadioItem.SELEN);
        // 13. Select radio
        // 14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
//        testSelectElements(Collections.singletonList("Selen"), ControlType.RADIO);

        // 15. Select in dropdown
        // 16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
//        testSelectElements(Collections.singletonList("Yellow"), ControlType.DROPDOWN);

        // 17. Unselect and assert checkboxes
        // 18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
//        testSelectElements(Arrays.asList("Water", "Wind"), ControlType.CHECKBOX);
    }

}

