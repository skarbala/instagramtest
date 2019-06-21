package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pages.MainPage;
import pages.newpost.FilterPage;
import pages.newpost.FirstPage;
import pages.newpost.SharePage;

public class PostCreationSteps {

    private MainPage mainPage;

    @When("user starts new post")
    public void iStartNewPost() {
        new MainPage().startNewPost();
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

    @And("user adds text '([?#\\w\\s]*)'")
    public void userAddsText(String text) {
        new SharePage().addCaption(text);
    }

    @And("user shares the post")
    public void userSharesThePost() {
        new SharePage().next();
    }
}
