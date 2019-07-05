package hw5.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public static final String BASE_URL = "https://epam.github.io/JDI/";
    public static final String DIFFERENT_ELEMENTS_PAGE_URL = BASE_URL + "different-elements.html";

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

}
