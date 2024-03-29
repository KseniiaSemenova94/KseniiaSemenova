package hw6.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import hw6.pages.DifferentElements;
import hw6.pages.HomePage;
import hw6.pages.UserTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        Context.setDriver(driver);
    }

    @After
    public void closeDriver() {
        Context.getDriver().close();
        Context.setDriver(null);
        HomePage.closePage();
        UserTable.closePage();
        DifferentElements.closePage();
    }

}
