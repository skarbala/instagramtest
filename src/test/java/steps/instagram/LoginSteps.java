package steps.instagram;

import static org.openqa.selenium.By.id;

import static com.codeborne.selenide.Selenide.$;

import static context.DriverProvider.getAppiumDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.HomePage;
import utils.TestProperties;

public class LoginSteps {
    @Given("user is logged in")
    public void iAmLoggedIn() {
        getAppiumDriver().findElement(id("log_in_button")).click();
        $(id("login_username")).setValue(TestProperties.getInstance().getProperty("ig.user"));
        $(id("password")).setValue(TestProperties.getInstance().getProperty("ig.password"));
        $(id("button_text")).click();
    }

    @Then("post appears in feed")
    public void postAppearsInFeed() {
        new HomePage().checkPhotoAppearsInFeed();
    }
}
