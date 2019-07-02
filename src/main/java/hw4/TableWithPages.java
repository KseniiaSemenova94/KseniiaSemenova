package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class TableWithPages extends Page{

    @FindBy(css = "select.uui-form-element")
    private SelenideElement entriesField;

    @FindBy(id = "mCSB_2")
    private SelenideElement rightSection;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private ElementsCollection logElements;

    @FindBy(css = "tbody > tr")
    private ElementsCollection tableRows;

    @FindBy(css = "input.uui-form-element[type='search']")
    private SelenideElement searchField;

    public TableWithPages() {
        page(this);
    }

    public boolean isTextPresentInLastLogEntry(String text) {
        String lastElementText = logElements.get(1).getText();
        return lastElementText.contains(text);
    }

    public SelenideElement getEntriesField() {
        return entriesField;
    }

    public SelenideElement getRightSection() {
        return rightSection;
    }

    public ElementsCollection getTableRows() {
        return tableRows;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }
}
