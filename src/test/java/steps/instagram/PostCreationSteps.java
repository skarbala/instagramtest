package steps.instagram;

import static org.openqa.selenium.By.id;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

import static context.Context.POST_TEXT;

import com.codeborne.selenide.Condition;

import context.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.newpost.FilterPage;
import pages.newpost.FirstPage;

public class PostCreationSteps {

    private HomePage mainPage;

    @When("user starts new post")
    public void iStartNewPost() {
        new HomePage().startNewPost();
    }

    @And("user gets to Filter page")
    public void getToFilterPage() {
        new FirstPage().next();
    }

    @And("user selects filter (\\w*)")
    public void selectFilterLudwig(String filterName) {
        new FilterPage().selectFilter(filterName);
    }

    @And("user gets to Share page")
    public void userGetsToSharePage() {
        new FilterPage().next();
    }

    @And("user adds text")
    public void userAddsText() {
        String defaultText = "Automaticky post | QA meetup | 5.11.2019 #furbo #slido";
        ScenarioContext.getInstance().setContext(POST_TEXT, defaultText);
        $(id("next_button_textview"))
            .waitUntil(Condition.visible, 15000);
        $(id("caption_text_view")).sendKeys((String) ScenarioContext.getInstance().getContext(POST_TEXT));
    }

    @And("user shares the post")
    public void userSharesThePost() {
        $(id("next_button_textview")).click();
    }

    @And("user takes photo")
    public void userTakesPhoto() throws InterruptedException {
        $(byXpath("//android.widget.TextView[@text='GALLERY']"))
            .should(Condition.appear);
        $(byXpath("//android.widget.TextView[@text='PHOTO']")).click();
        Thread.sleep(3000);
        $(byId("shutter_button")).click();
    }
}
