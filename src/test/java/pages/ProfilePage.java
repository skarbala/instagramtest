package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static context.DriverProvider.getAppiumDriver;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;
import static utils.GesturesUtils.swipeVertically;

public class ProfilePage {
    public ProfilePage() {
        waitUntilPageLoaded();
    }

    private void waitUntilPageLoaded() {
        $(xpath("//android.widget.ImageView[@content-desc='Profile picture of furbo.slav']"))
            .waitUntil(Condition.visible, 15000);
    }


    public PostDetailPage openFirstPhoto() {
        int screenHeight = getAppiumDriver().manage().window().getSize().height;
        swipeVertically((int) (screenHeight * 0.5), (int) (screenHeight * 0.3));

        $$(id("android:id/list")).get(0).click();
        return new PostDetailPage();
    }
}
