package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static context.DriverProvider.getAppiumDriver;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPage {

    public ProfilePage openProfile() {
        new WebDriverWait(getAppiumDriver(), 10)
            .until(visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@content-desc='Profile']")))
            .click();
        waitUntilProfileIsLoaded();
        return new ProfilePage();
    }

    private void waitUntilProfileIsLoaded() {
        new WebDriverWait(getAppiumDriver(), 10)
            .until(visibilityOfElementLocated(
                xpath("//android.widget.ImageView[@content-desc='Profile picture of furbo.slav']")
            ));
    }

    public void startNewPost() {
        new WebDriverWait(getAppiumDriver(), 20)
            .until(visibilityOfElementLocated(xpath("//android.widget.FrameLayout[@content-desc='Camera']")))
            .click();
    }
}
