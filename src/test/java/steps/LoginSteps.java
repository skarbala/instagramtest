package steps;

import cucumber.api.java.en.Given;
import pages.LoginPage;

import static context.DataProvider.getUser;

public class LoginSteps {
    @Given("user is logged in")
    public void iAmLoggedIn() {
        new LoginPage()
            .loginAsUser(getUser("furbo.slav"));
    }

}
