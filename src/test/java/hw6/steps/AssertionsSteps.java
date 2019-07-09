package hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import hw6.enums.PageTitle;
import hw6.enums.UserTableElement;
import hw6.hooks.Context;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class AssertionsSteps extends BaseSteps {

    @Then("'([^\"]*)' page is opened")
    public void pageIsOpened(PageTitle pageTitle) {
        assertEquals(Context.getDriver().getTitle(), pageTitle.getName());
    }

    @Then("'(\\d+)' '([^\"]*)' are displayed on Users Table on User Table Page")
    public void userTableElementsAreDisplayed(int amount, UserTableElement element) {
        assertEquals(amount, userTable.getTableElements(element).size());
    }

    @Then("User table contains following values:")
    public void userTableShouldContainValues(DataTable arg) {
        List<Map<String, String>> expectedTable = arg.asMaps(String.class, String.class);
        List<Map<String, String>> actualTable = userTable.getEntries();
        assertEquals(expectedTable.size(), actualTable.size());
        for (int i = 0; i < expectedTable.size(); i++) {
            assertEquals(expectedTable.get(i).get("Number"), actualTable.get(i).get("Number"));
            assertEquals(expectedTable.get(i).get("Description"), actualTable.get(i).get("Description"));
            assertEquals(expectedTable.get(i).get("User"), actualTable.get(i).get("User"));
        }
    }
}
