package hw6.pages;

import hw6.enums.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Page {

    @FindBy(className = "icons-benefit")
    private List<WebElement> images;

    @FindBy(className = "benefit-txt")
    private List<WebElement> imagesText;

    @FindBy(name = "main-title")
    private List<WebElement> mainTitle;

    @FindBy(name = "jdi-text")
    private List<WebElement> mainSubtitle;

    private static HomePage instance;

    private HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getTableElements(Element element) {
        switch (element) {
            case PICTURE:
                return images;
            case TEXT_UNDER_PICTURE:
                return imagesText;
            case HEADLINE_TEXT:
                return mainTitle;
            case DESCRIPTION_TEXT:
                return mainSubtitle;
            default:
                return null;
        }
    }

    public static HomePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new HomePage(driver);
        }
        return instance;
    }

    public static void closePage() {
        instance = null;
    }

}
