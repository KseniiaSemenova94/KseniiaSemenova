package hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw3.enums.ResultValue;
import hw4.builder.MetalAndColorsData;
import hw4.enums.FormField;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MetalAndColorsPage extends Page {
    MetalAndColorsData data;

    private static final String caretCss = "div.btn-group button[title=\"%s\"] span.caret";

    @FindBy(css = "#summary-block p.radio")
    private ElementsCollection radios;

    @FindBy(css = "#elements-block p.checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = "#metals li")
    private ElementsCollection metalDropdownItems;

    @FindBy(css = "#colors li")
    private ElementsCollection colorDropdownItems;

    @FindBy(css = "#vegetables li")
    private ElementsCollection vegetablesDropdownItems;

    @FindBy(id = "submit-button")
    private SelenideElement submitButton;

    @FindBy(css = "#mCSB_2 ul.results li")
    private ElementsCollection results;

    public MetalAndColorsPage() {
        page(this);
    }

    public void fillForm(MetalAndColorsData data) {

        this.data = data;

        if (data.getOdd() != null) {
            clickFormItems(radios, data.getOdd().toString());
        }

        if (data.getEven() != null) {
            clickFormItems(radios, data.getEven().toString());
        }

        if (data.getElements() != null && data.getElements().size() != 0) {
            for (String el : data.getElements()) {
                clickFormItems(checkboxes, el);
            }
        }

        if (data.getMetal() != null) {
            String metalsCss = String.format(caretCss, Metals.METALS.getName());
            $(metalsCss).click();
            clickFormItems(metalDropdownItems, data.getMetal());
        }

        if (data.getColor() != null) {
            String colorsCss = String.format(caretCss, FormField.COLORS.getName());
            $(colorsCss).click();
            clickFormItems(colorDropdownItems, data.getColor());
        }

        if (data.getVegetables() != null && data.getVegetables().size() != 0) {
            for (String veg : data.getVegetables()) {
                $(By.xpath("//div[@id = 'salad-dropdown']//button")).click();
                $(By.xpath("//a[@class='checkbox']/label[contains(., '" + Vegetables.VEGETABLES.getName() + "')]")).click();
            }
        }
    }

    public void checkForm() {

        if (data.getOdd() != null && data.getEven() != null) {
            Integer sum = data.getEven() + data.getOdd();
            results.find(Condition.text(ResultValue.SUMMARY.getName())).shouldHave(text(sum.toString()));
        }

        if (data.getElements() != null && data.getElements().size() != 0) {
            data.getElements().stream()
                    .forEach(element -> results.find(text(ResultValue.ELEMENTS.getName())).shouldHave(text(element)));
        }

        if (data.getColor() != null) {
            results.find(text(ResultValue.COLOR.getName())).shouldHave(text(data.getColor()));
        }

        if (data.getMetal() != null) {
            results.find(text(ResultValue.METAL.getName())).shouldHave(text(data.getMetal()));
        }

        if (data.getVegetables() != null && data.getVegetables().size() != 0) {
            data.getVegetables().stream()
                    .forEach(element -> results.find(text(ResultValue.VEGETABLES.getName())).shouldHave(text(element)));
        }
    }

    public void submitForm() {
        submitButton.click();
    }


    private void clickFormItems(ElementsCollection items, String text) {
        items.stream().filter(i -> text.equalsIgnoreCase(i.getText())).findAny()
                .ifPresent(SelenideElement::click);
    }
}
