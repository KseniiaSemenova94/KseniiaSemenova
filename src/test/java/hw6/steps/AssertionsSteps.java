package hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import hw3.enums.CheckboxItem;
import hw3.enums.RadioItem;
import hw3.enums.ServiceOption;
import hw4.enums.Colors;
import hw6.enums.CommonComponent;
import hw6.enums.PageTitle;
import hw6.enums.Element;
import hw6.enums.UserTableUserIndex;
import hw6.hooks.Context;
import hw6.pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class AssertionsSteps extends BaseSteps {

    @Then("'([^\"]*)' page is opened")
    public void pageIsOpened(PageTitle pageTitle) {
        assertEquals(Context.getDriver().getTitle(), pageTitle.getName());
    }

    @Then("'(\\d+)' '([^\"]*)' are displayed on '([^\"]*)' Page")
    public void userTableElementsAreDisplayed(int amount, Element element, PageTitle pageTitle) {
        Page page;
        switch (pageTitle) {
            case HOME_PAGE: {
                page = homePage;
                break;
            }
            case USER_TABLE: {
                page = userTable;
                break;
            }
            case DIFFERENT_ELEMENTS: {
                page = differentElements;
                break;
            }
            default:
                page = null;

        }

        if (page != null) {
            List<WebElement> elements = page.getTableElements(element);
            assertEquals(amount, elements.size());
            for (WebElement el : elements) {
                assertTrue(el.isDisplayed());
            }
        }
    }

    @Then("User table contains following values:")
    public void userTableShouldContainValues(DataTable dataTable) {
        List<Map<String, String>> expectedTable = dataTable.asMaps(String.class, String.class);
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

    @Then("User name in the right-top side of screen is displayed and equals to '([^\"]*)'")
    public void userNameIsDisplayedAndEquals(String userName) {
        assertTrue(homePage.isUserNameDisplayed());
        assertEquals(homePage.getUserNameText(), userName);
    }

    @Then("'([^\"]*)' dropdown contains options:")
    public void dropdownContainsOptions(CommonComponent component, DataTable dataTable) {
        List<ServiceOption> options = dataTable.asList(ServiceOption.class);
        List<String> expectedItems = options.stream()
                .map(option -> component == CommonComponent.HEADER ? option.getName().toUpperCase() : option.getName())
                .collect(Collectors.toList());
        List<String> actualItems = null;
        if(component == CommonComponent.HEADER) {
            actualItems = homePage.getOpenedHeaderDropdownOptions();
        } else if (component == CommonComponent.LEFT_SECTION) {
            actualItems = homePage.getOpenedLeftSectionDropdownOptions();
        }
        assertNotNull(actualItems);
        assertEquals(actualItems.size(), expectedItems.size());
        Collections.sort(actualItems);
        Collections.sort(expectedItems);
        assertEquals(actualItems, expectedItems);
    }

    @Then("Component '([^\"]*)' exists on Different Elements Page")
    public void componentExistsOnPage(CommonComponent component) {
        if (component == CommonComponent.LEFT_SECTION) {
            assertTrue(differentElements.isLeftSectionDisplayed());
        } else if(component == CommonComponent.RIGHT_SECTION) {
            assertTrue(differentElements.isRightSectionDisplayed());
        }
    }

    @Then("Log rows are displayed, '([^\"]*)' name and its status/value is corresponding to:")
    public void logsAreDisplayedAndCorrect(Element element, DataTable dataTable) {
        List<String> items = new ArrayList<>();
        switch (element) {
            case CHECKBOX: {
                items = dataTable.asList(CheckboxItem.class)
                        .stream().map(el -> el.getName()).collect(Collectors.toList());
                break;
            }
            case RADIO: {
                items = dataTable.asList(RadioItem.class)
                        .stream().map(el -> el.getName()).collect(Collectors.toList());
                break;
            }
            case DROPDOWN: {
                items = dataTable.asList(Colors.class)
                        .stream().map(el -> el.getName()).collect(Collectors.toList());
            }
        }

        for (String item : items) {
            assertTrue(differentElements.isLogElementsDisplayed());
            assertTrue(differentElements.isElementPresentInLogs(item, element));
        }


    }
}
