package hw4.ex1;

import com.codeborne.selenide.CollectionCondition;
import hw3.enums.HeaderMenuItem;
import hw3.enums.LeftSideMenuItem;
import hw3.enums.PageTitle;
import hw3.enums.ServiceOption;
import hw4.HomePage;
import hw4.TableWithPages;
import hw4.base.BaseTest;
import hw4.enums.DataTableEvent;
import hw4.enums.EntriesFieldValue;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;


public class Exercise1 extends BaseTest {

    private static final String SEARCH_TEXT = "Custom";

    @Test
    public void Exercise1Test() {

        HomePage hp = open(HOME_PAGE_URL, HomePage.class);

        Assert.assertEquals(title(), PageTitle.HOME_PAGE.getName());

        hp.login(LOGIN, PASSWORD);

        hp.getUserName().shouldHave(text(USERNAME));

        hp.clickOnHeaderMenuItem(HeaderMenuItem.SERVICE);
        hp.getOpenedHeaderDropdownOptions()
                .shouldHave(CollectionCondition.textsInAnyOrder(ServiceOption.getAllValues()));

        hp.clickOnLeftSectionMenuItem(LeftSideMenuItem.SERVICE);
        hp.getOpenedLeftSectionDropdownOptions()
                .shouldHave(CollectionCondition.textsInAnyOrder(ServiceOption.getAllValues()));

        hp.clickOnHeaderMenuItem(HeaderMenuItem.SERVICE);
        hp.clickOnHeaderDropdownOption(ServiceOption.TABLE_WITH_PAGES);
        Assert.assertEquals(title(), PageTitle.TABLE_WITH_PAGES.getName());

        TableWithPages twp = new TableWithPages();

        twp.getEntriesField().shouldBe(value(EntriesFieldValue.VALUE_5.getName()));

        twp.getRightSection().shouldBe(exist);

        twp.getLeftSection().shouldBe(exist);

        twp.getEntriesField().selectOptionByValue(EntriesFieldValue.VALUE_10.getName());
        twp.getEntriesField().shouldBe(value(EntriesFieldValue.VALUE_10.getName()));

        twp.isTextPresentInLastLogEntry(DataTableEvent.LENGTH.getName());
        twp.isTextPresentInLastLogEntry(EntriesFieldValue.VALUE_10.getName());

        twp.getTableRows().shouldBe(CollectionCondition.size(10));

        twp.getSearchField().sendKeys(SEARCH_TEXT);

        twp.getTableRows().stream().forEach(el -> el.shouldHave(text(SEARCH_TEXT)));

    }
}
