package hw2.ex2;

import hw2.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
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
        loginTest(USER_LOGIN, USER_PASSWORD, USER_NAME);

        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        driver.findElement(By.className("dropdown-toggle")).click();
        testItemsDisplayed(SERVICE_DROPDOWN_ELEMENTS.size(), SERVICE_ELEMENTS_LOCATOR_TOP);
        testItemsHasText(SERVICE_DROPDOWN_ELEMENTS.stream().map(el -> el.toUpperCase()).collect(Collectors.toList()),
                SERVICE_ELEMENTS_LOCATOR_TOP);

        // 6. Click on Service subcategory in the left section and check that drop down contains options
        driver.findElement(By.xpath("//li[@class='menu-title' and @index='3']")).click();
        testItemsDisplayed(SERVICE_DROPDOWN_ELEMENTS.size(), SERVICE_ELEMENTS_LOCATOR_LEFT);
        testItemsHasText(SERVICE_DROPDOWN_ELEMENTS, SERVICE_ELEMENTS_LOCATOR_LEFT);

        // 7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.className("dropdown-toggle")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//*[ text() = 'Different elements']")).click();
        assertEquals(driver.getCurrentUrl(), DIFFERENT_ELEMENTS_PAGE_URL);

        // 8. Check interface on Different elements page, it contains all needed elements
        testItemsDisplayed(4, By.className("label-checkbox"));
        testItemsDisplayed(4, By.className("label-radio"));
        assertTrue(driver.findElement(By.cssSelector("button[value='Default Button']")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("input.uui-button")).isDisplayed());

        // 9. Assert that there is Right Section
        assertTrue(driver.findElement(By.name("log-sidebar")).isDisplayed());

        // 10. Assert that there is Left Section
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());

        // 11. Select checkboxes
        List<WebElement> checkboxLabels = driver.findElements(By.xpath("//label[@class='label-checkbox']"));
        List<WebElement> selectedLabels = new ArrayList<>();
        for (WebElement we : checkboxLabels) {
            if (we.getText().equals("Water") || we.getText().equals("Wind")) {
                we.click();
                we.findElement(By.tagName("input")).isSelected();
                selectedLabels.add(we);
            }
        }

        // 12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        testLog(selectedLabels);
    }

    protected void testLog(List<WebElement> elements) {
        SoftAssert sa = new SoftAssert();
        Collections.reverse(elements);
        List<WebElement> logElements = driver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"));
        for (int i = 0; i < elements.size(); i++) {
            sa.assertTrue(logElements.get(i).isDisplayed());
            String logText = logElements.get(i).getText();
            String name = logText.substring(logText.indexOf(" ") + 1, logText.lastIndexOf(":"));
            assertEquals(elements.get(i).getText(), name);
        }
        sa.assertAll();
    }
}
