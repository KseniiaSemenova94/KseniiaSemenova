package hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import hw6.enums.PageTitle;
import hw6.enums.UserTableElement;
import hw6.enums.UserTableUserIndex;
import hw6.hooks.Context;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @Then("log row has '([^\"]*)' text in log section")
    public void logRowHasTextInLogSection(String text) {
        assertTrue(userTable.getLogText().contains(text));
    }

    @Then("droplist for '([^\"]*)' contains values")
    public void dropListElementsAssertion(UserTableUserIndex user, List<String> expectedElements) {
        List<String> temp = new Select(userTable.getDropdowns().get(user.getIndex()))
                .getOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(temp, equalTo(expectedElements));
    }

}
