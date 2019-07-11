package hw6.pages;

import hw3.enums.ControlType;
import hw6.enums.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class DifferentElements extends Page {

    private static DifferentElements instance;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radios;

    @FindBy(css = "input.uui-button")
    private WebElement button;

    @FindBy(css = "button[value='Default Button']")
    private WebElement defaultButton;

    @FindBy(css = "select.uui-form-element")
    private List<WebElement> dropdown;

    @FindBy(css = "select.uui-form-element")
    WebElement selectBox;

    @FindBy(tagName = "option")
    List<WebElement> selectBoxOptions;

    @FindBy(css = ".panel-body-list > li:first-child")
    WebElement lastLogEntry;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    List<WebElement> logElements;

    private DifferentElements(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getTableElements(Element element) {
        switch (element) {
            case CHECKBOX:
                return checkboxes;
            case RADIO:
                return radios;
            case BUTTON:
                return Arrays.asList(button, defaultButton);
            case DROPDOWN:
                return dropdown;
            default:
                return null;
        }
    }

    public void selectControl(Element element, String name) {
        switch (element) {
            case RADIO:
            case CHECKBOX: {
                final WebElement label =
                        getLabelByText(element == Element.CHECKBOX ? checkboxes : radios, name);
                if (label != null) {
                    final WebElement input = label.findElement(By.tagName("input"));
                    input.click();
                }
                break;
            }
            case DROPDOWN: {
                selectBox.click();
                WebElement option = selectBoxOptions.stream()
                        .filter(o -> o.getText().equals(name)).findAny().orElse(null);
                if (option != null) {
                    option.click();
                }
                break;
            }
        }
    }

    public static DifferentElements getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new DifferentElements(driver);
        }
        return instance;
    }

    public boolean isLogElementsDisplayed() {
        return lastLogEntry.isDisplayed();
    }

    public boolean isElementPresentInLogs(String elementText, Element element) {
        boolean isTextContains = logElements.stream().anyMatch(el -> el.getText().contains(elementText));
        boolean isValid = true;

        if (element == Element.CHECKBOX) {
            isValid = logElements.stream().anyMatch(el -> el.getText().contains(getLabelByText(checkboxes, elementText)
                    .findElement(By.tagName("input")).isSelected() ? "true" : "false"));
        }

        return element == Element.CHECKBOX ? isTextContains && isValid : isTextContains;
    }

    public static void closePage() {
        instance = null;
    }


    private WebElement getLabelByText(List<WebElement> items, String text) {
        return items.stream()
                .filter(control -> control.getText().equals(text))
                .findAny()
                .orElse(null);
    }

}
