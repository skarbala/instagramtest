package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static context.TestBase.getAppiumDriver;
import static utils.GesturesUtils.swipeUp;

public class ProfilePage {

    public PostDetailPage openFirstPhoto() {
        int screenHeight = getAppiumDriver().manage().window().getSize().height;
        swipeUp((int) (screenHeight * 0.5), (int) (screenHeight * 0.3));
        MobileElement listOfPhotos = getAppiumDriver().findElement(By.id("android:id/list"));
        listOfPhotos.findElements(By.className("android.widget.ImageView")).get(0).click();
        return new PostDetailPage();
    }
}
