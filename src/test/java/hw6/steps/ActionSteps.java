package hw6.steps;

import cucumber.api.java.en.When;
import hw3.enums.HeaderMenuItem;
import hw3.enums.ServiceOption;

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
}
