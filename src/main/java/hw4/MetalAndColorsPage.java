package hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.builder.MetalAndColorsData;
import hw4.enums.FormField;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class MetalAndColorsPage extends Page {
    MetalAndColorsData data;

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

    @FindBy(id = "metals")
    private SelenideElement metalDropdown;

    @FindBy(css = "button.btn.dropdown-toggle.selectpicker.btn-default")
    private SelenideElement colorDropdown;

    @FindBy(id = "salad-dropdown")
    private SelenideElement saladDropdown;

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
            metalDropdown.click();
            clickFormItems(metalDropdownItems, data.getMetal());
        }

        if (data.getColor() != null) {
            colorDropdown.click();
            clickFormItems(metalDropdownItems, data.getMetal());
        }

        if (data.getVegetables() != null && data.getVegetables().size() != 0) {
            for (String veg : data.getVegetables()) {
                clickFormItems(vegetablesDropdownItems, veg);
            }
        }
    }

    public void checkForm() {
        Integer sum = data.getEven() + data.getOdd();
        results.find(Condition.text(FormField.SUMMARY.getName())).shouldHave(text(sum.toString()));

        if (data.getElements() != null && data.getElements().size() != 0) {
            data.getElements().stream()
                    .forEach(element -> results.find(text(FormField.ELEMENTS.getName())).shouldHave(text(element)));
        }

        if (data.getColor() != null) {
            results.find(text(FormField.COLOR.getName())).shouldHave(text(data.getColor()));
        }

        if (data.getMetal() != null) {
            results.find(text(FormField.METAL.getName())).shouldHave(text(data.getMetal()));
        }

        if (data.getVegetables() != null && data.getVegetables().size() != 0) {
            data.getVegetables().stream()
                    .forEach(element -> results.find(text(FormField.VEGETABLES.getName())).shouldHave(text(element)));
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
