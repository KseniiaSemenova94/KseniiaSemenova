package hw2.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseTest {

    protected final String USER_LOGIN = "epam";
    protected final String USER_PASSWORD = "1234";
    protected final String USER_NAME = "PITER CHAILOVSKII";
    protected final String BASE_URL = "https://epam.github.io/JDI";
    protected final String INDEX_PAGE_URL = BASE_URL + "/index.html";
    protected final String DIFFERENT_ELEMENTS_PAGE_URL = BASE_URL + "/different-elements.html";
    protected final String BROWSER_HOME_PAGE_TITLE = "Home Page";
    protected final List<String> HEADER_TEXT_ELEMENTS = Arrays
            .asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    protected final By HEADER_TEXT_LOCATOR = By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li");
    protected final List<String> UNDER_ICONS_TEXTS = Arrays
            .asList("To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                    "To be flexible and\n" + "customizable", "To be multiplatform", "Already have good base\n" +
                            "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");
    protected final By UNDER_ICONS_TEXTS_LOCATOR = By.className("benefit-txt");
    protected final By MAIN_TITLE_LOCATOR = By.name("main-title");
    protected final By MAIN_SUBTITLE_LOCATOR = By.name("jdi-text");
    protected final By JDI_GITHUB_LOCATOR =  By.xpath("//h3[@class='text-center']/a");
    protected final List<String> SERVICE_DROPDOWN_ELEMENTS = Arrays.asList("Support", "Dates", "Search", "Complex Table",
            "Simple Table", "User Table", "Table with pages", "Different elements", "Performance");
    protected final By SERVICE_ELEMENTS_LOCATOR_TOP = By.xpath("//ul[@class='dropdown-menu']/li");
    protected final By SERVICE_ELEMENTS_LOCATOR_LEFT = By.xpath("//li[@class='menu-title' and @index='3']/ul//a");


    protected WebDriver driver;

    @BeforeSuite
    public void setUpDriverPath() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://epam.github.io/JDI");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    protected void loginTest(String login, String password, String userName) {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), userName);
    }

    protected void testItemsHasText(List<String> expectedHeaderMenuItems, By by) {
        List<String> actualHeaderMenuItems = driver
                .findElements(by)
                .stream().map(el -> el.getText())
                .collect(Collectors.toList());
        assertEquals(actualHeaderMenuItems.size(), expectedHeaderMenuItems.size());
        Collections.sort(actualHeaderMenuItems);
        Collections.sort(expectedHeaderMenuItems);
        assertEquals(actualHeaderMenuItems, expectedHeaderMenuItems);
    }

    protected void testItemsDisplayed(int numberOfItems, By by) {
        List<WebElement> items = driver.findElements(by);
        assertEquals(items.size(), numberOfItems);
        SoftAssert sa = new SoftAssert();
        for (int i = 0; i < numberOfItems; i++) {
            sa.assertTrue(items.get(i).isDisplayed());
        }
        sa.assertAll();
    }

    protected void elementDisplayedAndHasText(String text, By by) {
        WebElement element = driver.findElement(by);
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), text);
    }
}
