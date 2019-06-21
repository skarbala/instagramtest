package steps;

import cucumber.api.java.en.And;
import pages.PostDetailPage;

public class PostDetailSteps {
    @And("post contains text '([?#\\w\\s]*)'")
    public void postContainsText(String text) {
        new PostDetailPage().checkDescription(text);
    }
}
