package hw6.hooks;

import org.openqa.selenium.WebDriver;

public class Context {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    static void setDriver(WebDriver driver) {
        Context.driver = driver;
    }
}
