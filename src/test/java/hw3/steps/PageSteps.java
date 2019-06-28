package hw3.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class PageSteps {

    protected void checkItemsAreDisplayed(List<WebElement> items) {
        SoftAssert sa = new SoftAssert();
        for (WebElement item : items) {
            sa.assertTrue(item.isDisplayed());
        }
        sa.assertAll();
    }

    protected void checkItemsHaveText(List<String> expectedHeaderMenuItems, List<WebElement> actualHeaderMenuElements) {
        List<String> actualHeaderMenuItems = actualHeaderMenuElements.stream().map(el -> el.getText())
                .collect(Collectors.toList());
        assertEquals(actualHeaderMenuItems.size(), expectedHeaderMenuItems.size());
        Collections.sort(actualHeaderMenuItems);
        Collections.sort(expectedHeaderMenuItems);
        assertEquals(actualHeaderMenuItems, expectedHeaderMenuItems);
    }
}
