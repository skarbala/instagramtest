package steps;

import static org.openqa.selenium.By.id;

import static com.codeborne.selenide.Selenide.$;

import static context.DataProvider.getUser;
import static context.DriverProvider.getAppiumDriver;

import context.DriverProvider;
import context.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.HomePage;

public class LoginSteps {
    @Given("user is logged in")
    public void iAmLoggedIn() {
        User user = getUser("furbo.slav");
        getAppiumDriver().findElement(id("log_in_button")).click();
        $(id("login_username")).setValue(user.getUserName());
        $(id("password")).setValue(user.getPassword());
        $(id("button_text")).click();
    }

    @Then("post appears in feed")
    public void postAppearsInFeed() {
        new HomePage().checkPhotoAppearsInFeed();
    }
}
