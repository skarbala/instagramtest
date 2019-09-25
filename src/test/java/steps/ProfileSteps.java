package steps;

import cucumber.api.java.en.Then;
import pages.HomePage;
import pages.ProfilePage;

public class ProfileSteps {
    @Then("post is displayed in user's gallery")
    public void postIsDisplayedInUserSGallery() {
        new HomePage().openProfile();
        new ProfilePage().openFirstPhoto();
    }
}
