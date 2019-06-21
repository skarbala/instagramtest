package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static context.TestBase.getAppiumDriver;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPage {

    public MainPage() {

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

    public void startNewPost() {
        new WebDriverWait(getAppiumDriver(), 20)
            .until(visibilityOfElementLocated(xpath("//android.widget.FrameLayout[@content-desc='Camera']")));
        getAppiumDriver().findElement(xpath("//android.widget.FrameLayout[@content-desc='Camera']")).click();
    }
}
