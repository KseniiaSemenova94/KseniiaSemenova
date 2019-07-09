package hw6.steps;

import cucumber.api.java.en.When;

public class ActionSteps extends BaseSteps{

    @When("I login as user '([^\"]*)'")
    public void ILoginAsUser(String username) {
        if (username.equals(USERNAME)) {
            homePage.login(LOGIN, PASSWORD);
        }
    }
}
