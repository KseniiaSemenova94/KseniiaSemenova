package hw3.base;


import hw3.enums.ControlType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

// TODO I could see unused fields and method
// TODO If they are not used please do not forget delete them

public class BaseTest {

    public static final String BASE_URL = "https://epam.github.io/JDI/";
    public static final String DIFFERENT_ELEMENTS_PAGE_URL = BASE_URL + "different-elements.html";


    protected final String USER_LOGIN = "epam";
    protected final String USER_PASSWORD = "1234";
    protected final String USER_NAME = "PITER CHAILOVSKII";
    protected final String INDEX_PAGE_URL = BASE_URL + "/index.html";
    protected final List<String> HEADER_TEXT_ELEMENTS = Arrays
            .asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
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
        driver.get(BASE_URL);
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

    protected void elementDisplayedAndHasText(String text, By by) {
        WebElement element = driver.findElement(by);
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), text);
    }

    protected void testSelectElements(List<String> texts, ControlType type) {
        texts.stream().forEach(text -> {
            if (type == ControlType.DROPDOWN) {
                WebElement select = driver.findElement(By.cssSelector("select.uui-form-element"));
                select.click();
                WebElement option = driver.findElement(By.xpath("//option[contains(.,'" + text + "')]"));
                option.click();
                assertTrue(option.isSelected());
                testLog(option.getText(), type, option.isSelected());
            }
            if (type == ControlType.CHECKBOX || type == ControlType.RADIO) {
                WebElement label = driver.findElement(By.xpath("//label[contains(.,'" + text + "')]"));
                WebElement input = label.findElement(By.tagName("input"));
                boolean initSelect = input.isSelected();
                input.click();
                if (type != ControlType.CHECKBOX || !initSelect) {
                    assertTrue(input.isSelected());
                } else {
                    assertFalse(input.isSelected());
                }
                testLog(label.getText(), type, input.isSelected());
            }
        });
    }


    private void testLog(String elementText, ControlType type, boolean isSelected) {
        WebElement logElement = driver.findElement(By.cssSelector(".panel-body-list > li:first-child"));
        assertTrue(logElement.isDisplayed());
        assertTrue(logElement.getText().contains(elementText));
        if (type == ControlType.CHECKBOX) {
            assertTrue(logElement.getText().contains(isSelected ? "true" : "false"));
        }
    }

}
