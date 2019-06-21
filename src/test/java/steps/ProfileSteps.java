package steps;

import cucumber.api.java.en.Then;
import pages.MainPage;
import pages.ProfilePage;

public class ProfileSteps {
    @Then("post is displayed in user's gallery")
    public void postIsDisplayedInUserSGallery() {
        new MainPage().openProfile();
        new ProfilePage().openFirstPhoto();
    }
}
