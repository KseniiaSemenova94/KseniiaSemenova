package hw2.ex2;

import hw2.base.BaseTest;
import hw2.base.ControlType;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Exercise2 extends BaseTest {

    @Test
    public void exercise2Test() {

        // 1. Open test site by URL
        assertEquals(driver.getCurrentUrl(), INDEX_PAGE_URL);

        // 2. Assert Browser title
        assertEquals(driver.getTitle(), BROWSER_HOME_PAGE_TITLE);

        // 3. Perform login
        // 4. Assert User name in the left-top side of screen that user is loggined
        login(USER_LOGIN, USER_PASSWORD, USER_NAME);

        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        driver.findElement(By.className("dropdown-toggle")).click();
        checkItemsDisplayed(SERVICE_DROPDOWN_ELEMENTS.size(), SERVICE_ELEMENTS_LOCATOR_TOP);
        checkItemsHasText(SERVICE_DROPDOWN_ELEMENTS.stream().map(el -> el.toUpperCase()).collect(Collectors.toList()),
                SERVICE_ELEMENTS_LOCATOR_TOP);

        // 6. Click on Service subcategory in the left section and check that drop down contains options
        driver.findElement(By.xpath("//li[@class='menu-title' and @index='3']")).click();
        checkItemsDisplayed(SERVICE_DROPDOWN_ELEMENTS.size(), SERVICE_ELEMENTS_LOCATOR_LEFT);
        checkItemsHasText(SERVICE_DROPDOWN_ELEMENTS, SERVICE_ELEMENTS_LOCATOR_LEFT);

        // 7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.className("dropdown-toggle")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//*[ text() = 'Different elements']")).click();
        assertEquals(driver.getCurrentUrl(), DIFFERENT_ELEMENTS_PAGE_URL);

        // 8. Check interface on Different elements page, it contains all needed elements
        checkItemsDisplayed(4, By.className("label-checkbox"));
        checkItemsDisplayed(4, By.className("label-radio"));
        assertTrue(driver.findElement(By.cssSelector("button[value='Default Button']")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("input.uui-button")).isDisplayed());

        // 9. Assert that there is Right Section
        assertTrue(driver.findElement(By.name("log-sidebar")).isDisplayed());

        // 10. Assert that there is Left Section
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());

        // 11. Select checkboxes
        // 12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        checkSelectElements(Arrays.asList("Water", "Wind"), ControlType.CHECKBOX);

        // 13. Select radio
        // 14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        checkSelectElements(Collections.singletonList("Selen"), ControlType.RADIO);

        // 15. Select in dropdown
        // 16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        checkSelectElements(Collections.singletonList("Yellow"), ControlType.DROPDOWN);

        // 17. Unselect and assert checkboxes
        // 18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        checkSelectElements(Arrays.asList("Water", "Wind"), ControlType.CHECKBOX);
    }

}

