package hw2.ex2;
import hw2.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Exercise2 extends BaseTest {

    @Test
    public void exercise2Test() {

        // 1. Open test site by URL
        assertEquals(driver.getCurrentUrl(), SITE_URL);

        // 2. Assert Browser title
        assertEquals(driver.getTitle(), BROWSER_HOME_PAGE_TITLE);

        // 3. Perform login
        // 4. Assert User name in the left-top side of screen that user is loggined
        loginTest(USER_LOGIN, USER_PASSWORD, USER_NAME);

        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        driver.findElement(By.className("dropdown-toggle")).click();
        testItemsDisplayed(SERVICE_DROPDOWN_ELEMENTS.size(), By.xpath("//ul[@class='dropdown-menu']/li"));

    }
}
