package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.builder.MetalAndColorsData;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class MetalAndColorsPage extends Page {

    @FindBy(css = "#summary-block p.radio")
    private ElementsCollection radios;

    @FindBy(css = "#elements-block p.checkbox")
    private ElementsCollection checkboxes;

    public MetalAndColorsPage() {
        page(this);
    }

    public void fillForm(MetalAndColorsData data) {

        if (data.getOdd() != null) {
            clickFormItems(radios, data.getOdd().toString());
        }

        if (data.getEven() != null) {
            clickFormItems(radios, data.getEven().toString());
        }

        if (data.getElements() != null && data.getElements().size() != 0) {
            clickFormItems(checkboxes, data.getEven().toString());
        }

        if(data.get) {

        }


    }


    private void clickFormItems(ElementsCollection items, String text) {
        items.stream().filter(i -> text.equalsIgnoreCase(i.getText())).findAny()
                .ifPresent(SelenideElement::click);
    }
}
