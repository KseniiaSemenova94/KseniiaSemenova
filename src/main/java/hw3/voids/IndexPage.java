package hw3.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IndexPage extends Page {

    @FindBy(className = "icons-benefit")
    private List<WebElement> images;

    @FindBy(className = "benefit-txt")
    private List<WebElement> imagesText;

    @FindBy(name = "main-title")
    private WebElement mainTitle;

    @FindBy(name = "jdi-text")
    private WebElement mainSubtitle;

    @FindBy(id = "iframe")
    private WebElement iframe;


    @FindBy(id = "epam_logo")
    private WebElement epamLogo;


    @FindBy(xpath = "//h3[@class='text-center']/a")
    private WebElement mainLink;


    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public Integer getImagesAmount() {
        return images.size();
    }

    public boolean areImagesDisplayed() {
        return allItemsAreDisplayed(images);
    }

    public boolean areImagesTextDisplayed() {
        return allItemsAreDisplayed(imagesText);
    }

    public Integer getImagesTextAmount() {
        return imagesText.size();
    }

    public String getMainTitleText() {
        return getItemText(mainTitle);
    }

    public boolean isMainTitleDisplayed() {
        return mainTitle.isDisplayed();
    }

    public boolean isMainSubtitleDisplayed() {
        return mainSubtitle.isDisplayed();
    }

    public String getMainSubtitleText() {
        return mainSubtitle.getText();
    }

    public boolean isIFrameDisplayed() { return iframe.isDisplayed(); }

    public void switchToIFrame() { driver.switchTo().frame("iframe"); }

    public boolean isLogoDisplayed() { return epamLogo.isDisplayed(); }

    public void switchToDefaultContent() { driver.switchTo().defaultContent(); }

    public boolean isMainLinkDisplayed() { return mainLink.isDisplayed(); }

    public String getMainLinkText() { return mainLink.getText(); }

    public String getMainLinkURL() { return mainLink.getAttribute("href"); }

}
