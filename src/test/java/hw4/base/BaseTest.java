package hw4.base;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;


import hw4.utils.FileUtils;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {

    protected static final Properties appProperties =
            FileUtils.readUserFromFile("src/test/resources/hw4/app.properties");

    protected static final String HOME_PAGE_URL = appProperties.getProperty("app.url");
    protected static final String LOGIN = appProperties.getProperty("user.login");
    protected static final String PASSWORD = appProperties.getProperty("user.password");
    protected static final String USERNAME = appProperties.getProperty("user.name");


    @BeforeMethod
    public void setUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.startMaximized = true;
        Configuration.screenshots = false;


    }


}
