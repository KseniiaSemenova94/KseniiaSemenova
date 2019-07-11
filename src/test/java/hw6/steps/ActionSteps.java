package hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import hw3.enums.*;
import hw4.enums.Colors;
import hw6.enums.Element;
import hw6.enums.UserTableUser;
import hw6.enums.UserTableUserIndex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ActionSteps extends BaseSteps{

    @When("I login as user '([^\"]*)'")
    public void ILoginAsUser(String username) {
        if (username.equals(USERNAME)) {
            homePage.login(LOGIN, PASSWORD);
        }
    }

    @When("I click on '([^\"]*)' button in Header")
    public void iClickOnButtonInHeader(HeaderMenuItem headerMenuItem) {
        homePage.clickOnHeaderMenuItem(headerMenuItem);
    }

    @When("I click on '([^\"]*)' button in Service dropdown")
    public void iClickOnHeaderDropdownOption(ServiceOption serviceOption) {
        homePage.clickOnHeaderDropdownOption(serviceOption.getName().toUpperCase());
    }

    @When("I select vip checkbox for '([^\"]*)'")
    public void iSelectVipCheckboxFor(UserTableUser user) {
        userTable.clickVipCheckboxFor(user.getName());
    }

    @When("I click on dropdown in column Type for user '([^\"]*)'")
    public void iClickOnDropdownForUser(UserTableUserIndex user) {
        userTable.clickOnDropDown(user);
    }

    @When("I click on '([^\"]*)' button in the left section")
    public void iClickOnButtonInLeftSection(LeftSideMenuItem leftSideMenuItem) {
        homePage.clickOnLeftSectionMenuItem(leftSideMenuItem);
    }

    @When("I select '([^\"]*)':")
    public void iSelect(Element element, DataTable dataTable) {
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
            differentElements.selectControl(element, item);
        }
    }
}
