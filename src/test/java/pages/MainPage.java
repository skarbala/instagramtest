package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static context.TestBase.getAppiumDriver;

public class MainPage {

    MainPage() {

    }

    public ProfilePage openProfile() {
        new WebDriverWait(getAppiumDriver(), 10)
            .until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@content-desc='Profile']")));
        getAppiumDriver().findElementByAccessibilityId("Profile").click();
        waitUntilProfileIsLoaded();
        return new ProfilePage();
    }

    private void waitUntilProfileIsLoaded() {
        new WebDriverWait(getAppiumDriver(), 10)
            .until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='Profile Photo']")));
    }
}
