package hw6.steps;

import cucumber.api.java.en.Given;
import hw6.hooks.Context;

public class GivenSteps extends BaseSteps {

    @Given("I am on Home Page")
    public void iAmOnHomePage() {
        Context.getDriver().get("https://epam.github.io/JDI/index.html");
    }

}

