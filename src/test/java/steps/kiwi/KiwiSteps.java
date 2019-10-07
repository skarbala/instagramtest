package steps.kiwi;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class KiwiSteps {
    @Given("I am on search page")
    public void iAmOnSearchPage() {
        $(byId("negative_button")).click();
        $(byId("search_button")).waitUntil(Condition.appears, 25000);
    }

    @When("I enter start destination")
    public void iEnterStartDestination() {
        $(byId("from_container")).click();
        $(byId("button_close")).waitUntil(Condition.visible, 15000);
        $(byId("input_text")).setValue("Ouagadougou");
        $$(byId("item_label_text_view"))
            .find(Condition.text("Ouagadougou"))
            .click();
    }

    @When("I enter end destination")
    public void iEnterEndDestination() {
        $(byId("to_container")).click();
        $(byId("button_close")).waitUntil(Condition.visible, 15000);
        $(byId("input_text")).setValue("Ulaanbaatar");
        $$(byId("item_label_text_view"))
            .find(Condition.text("Ulaanbaatar"))
            .click();
        System.out.println("WEfwef");
    }

    @When("I search for flight")
    public void iSearchForFlight() {
        $(byId("search_button")).click();
    }

    @Then("list of flights is visible")
    public void listOfFlightsIsVisible() {
        $(byId("results_list"))
            .waitUntil(Condition.appears, 15000)
            .findAll(byId("result"))
            .shouldHave(sizeGreaterThan(0), 15000);
    }

    @And("first flight contains price in correct format")
    public void firstFlightContainsPriceInCorrectFormat() {
        $(byId("results_list")).find(byId("result")).click();
        $(byId("button_book")).should(Condition.appear)
            .should(Condition.matchText("BOOK FOR \\$(,?.?\\d)+"));
    }
}
