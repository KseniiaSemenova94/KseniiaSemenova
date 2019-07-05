package hw5.voids;

import hw3.enums.ControlType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends Page {

    @FindBy(className = "label-checkbox")
    List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    List<WebElement> radios;

    @FindBy(css = "button[value='Default Button']")
    WebElement defaultButton;

    @FindBy(css = "input.uui-button")
    WebElement button;

    @FindBy(css = "select.uui-form-element")
    WebElement dropdown;

    @FindBy(name = "log-sidebar")
    WebElement rightSection;

    @FindBy(css = "select.uui-form-element")
    WebElement selectBox;

    @FindBy(tagName = "option")
    List<WebElement> selectBoxOptions;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    List<WebElement> logElements;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAllElementsOfTypeDisplayed(ControlType controlType) {
        switch (controlType) {
            case RADIO:
                return allItemsAreDisplayed(radios);
            case CHECKBOX:
                return allItemsAreDisplayed(checkboxes);
            case BUTTON:
                return button.isDisplayed() && defaultButton.isDisplayed();
            case DROPDOWN:
                return dropdown.isDisplayed();
            default:
                return false;
        }
    }

    public boolean selectControlAndGetState(ControlType controlType, String name) {
        switch (controlType) {
            case RADIO:
            case CHECKBOX: {
                final WebElement label =
                        getLabelByText(controlType == ControlType.CHECKBOX ? checkboxes : radios, name);
                if (label != null) {
                    final WebElement input = label.findElement(By.tagName("input"));
                    input.click();
                    return input.isSelected();
                }
                return false;
            }
            case DROPDOWN: {
                selectBox.click();
                WebElement option = selectBoxOptions.stream()
                        .filter(o -> o.getText().equals(name)).findAny().orElse(null);
                if (option != null) {
                    option.click();
                    return option.isSelected();
                }
                return false;
            }
            default:
                return false;
        }
    }

    public boolean isRightSectionDisplayed() {
        return rightSection.isDisplayed();
    }

    public boolean isLogElementsDisplayed() {
        return logElements.size() > 0 && logElements.get(0).isDisplayed();
    }

    private WebElement getLabelByText(List<WebElement> items, String text) {
        return items.stream()
                .filter(control -> control.getText().equals(text))
                .findAny()
                .orElse(null);
    }

    public boolean isElementPresentInLogs(String elementText, ControlType type, boolean initSelected) {
        String lastElementText = logElements.get(0).getText();
        boolean isTextContains = lastElementText.contains(elementText);
        boolean isValid = true;

        if (type == ControlType.CHECKBOX) {
            isValid = lastElementText.contains(initSelected ? "false" : "true");
        }

        return type == ControlType.CHECKBOX ? isTextContains && isValid : isTextContains;
    }
}


