package steps;

import context.ScenarioContext;
import cucumber.api.java.en.And;
import pages.PostDetailPage;

import static context.Context.POST_TEXT;

public class PostDetailSteps {
    @And("post contains correct text")
    public void postContainsText() {
        new PostDetailPage().checkDescription((String) ScenarioContext.getInstance().getContext(POST_TEXT));
    }
}
