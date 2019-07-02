package hw4.base;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;


import com.codeborne.selenide.Selenide;
import hw3.enums.PageTitle;
import hw4.HomePage;
import hw4.utils.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public class BaseTest {

    protected HomePage hp;

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

        commonTest();
    }

    public void commonTest() {
        hp = open(HOME_PAGE_URL, HomePage.class);

        Assert.assertEquals(title(), PageTitle.HOME_PAGE.getName());

        hp.login(LOGIN, PASSWORD);

        hp.getUserName().shouldHave(text(USERNAME));
    }

    @AfterMethod
    public void tearDown() {
        close();
    }


}
