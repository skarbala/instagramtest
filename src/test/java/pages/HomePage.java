package pages;

import com.codeborne.selenide.Condition;
import context.ScenarioContext;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static context.Context.POST_TEXT;
import static context.DriverProvider.getAppiumDriver;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;
import static utils.GesturesUtils.swipeVertically;

public class HomePage {

    public ProfilePage openProfile() {
        $(xpath("//android.widget.FrameLayout[@content-desc='Profile']")).click();
        return new ProfilePage();
    }

    public void startNewPost() {
        $(xpath("//android.widget.FrameLayout[@content-desc='Camera']"))
            .waitUntil(Condition.appear, 15000)
            .click();
    }

    public void checkPhotoAppearsInFeed() {
        $(id("row_feed_photo_profile_name"))
            .waitUntil(Condition.visible, 15000)
            .shouldHave(text("furbo.slav"));


        swipeUntilDescriptionIsDisplayed();
        $(id("row_feed_comment_textview_layout"))
            .should(exist)
            .shouldHave(text((String) ScenarioContext.getInstance().getContext(POST_TEXT)));
    }


    private void swipeUntilDescriptionIsDisplayed() {
        int height = getAppiumDriver().manage().window().getSize().height;
        int swipes = 0;
        final int MAX_SWIPES = 5;
        while (!isDescriptionDisplayed() && MAX_SWIPES >= swipes) {
            swipeVertically((int) (height * 0.6), (int) (height * 0.5));
            swipes++;
        }
    }

    private boolean isDescriptionDisplayed() {
        return getAppiumDriver().findElements(getFilterLocator()).size() == 1;
    }

    private By getFilterLocator() {
        return id("row_feed_comment_textview_layout");
    }
}
