package hw5.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;

public class BaseTest {

    public static final String BASE_URL = "https://epam.github.io/JDI/";
    public static final String DIFFERENT_ELEMENTS_PAGE_URL = BASE_URL + "different-elements.html";

    public static WebDriver driver;

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

    @Step("Browser title equals '{0}'")
    public void getTitle(String expectedTitle){
        assertEquals(driver.getTitle(), expectedTitle);
    }

}
