package hw6.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    private static HomePage instance;

    private HomePage(WebDriver driver) {
        super(driver);
    }

    public static HomePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new HomePage(driver);
        }
        return instance;
    }

}
