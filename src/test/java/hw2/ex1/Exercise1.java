package hw2.ex1;

import hw2.base.BaseTest;
import org.jsoup.select.Collector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class Exercise1 extends BaseTest {

    @Test
    public void exercise1Test() {

        // 1. Open test site by URL
        assertEquals(driver.getCurrentUrl(), SITE_URL);

        // 2. Assert Browser title
        assertEquals(driver.getTitle(), BROWSER_HOME_PAGE_TITLE);

        // 3. Perform login
        // 4. Assert User name in the left-top side of screen that user is loggined
        loginTest("epam", "1234", "PITER CHAILOVSKII");

        // 5. Assert Browser title
        assertEquals(driver.getTitle(), BROWSER_HOME_PAGE_TITLE);

        // 6. Assert that there are 4 items on the header section are displayed and they have proper texts
        testHeaderMenuItems(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));


    }

    private void testHeaderMenuItems(List<String> expectedHeaderMenuItems) {
        List<String> actualHeaderMenuItems = driver
                .findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li"))
                .stream().map(el -> el.getText())
                .collect(Collectors.toList());
        assertEquals(actualHeaderMenuItems.size(), actualHeaderMenuItems.size());
        assertEquals(actualHeaderMenuItems, expectedHeaderMenuItems);
    }

}
