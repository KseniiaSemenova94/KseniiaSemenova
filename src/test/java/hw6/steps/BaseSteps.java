package hw6.steps;

import hw4.utils.FileUtils;
import hw6.hooks.Context;
import hw6.pages.DifferentElements;
import hw6.pages.HomePage;
import hw6.pages.UserTable;

import java.util.Properties;

public class BaseSteps {

    protected static final Properties appProperties =
            FileUtils.readUserFromFile("src/test/resources/hw4/app.properties");

    protected static final String LOGIN = appProperties.getProperty("user.login");
    protected static final String PASSWORD = appProperties.getProperty("user.password");
    protected static final String USERNAME = appProperties.getProperty("user.name");

    protected HomePage homePage;
    protected UserTable userTable;
    protected DifferentElements differentElements;

    public BaseSteps() {
        homePage = HomePage.getInstance(Context.getDriver());
        userTable = UserTable.getInstance(Context.getDriver());
        differentElements = DifferentElements.getInstance(Context.getDriver());
    }
}
