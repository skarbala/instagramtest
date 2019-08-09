package pages;

import io.appium.java_client.MobileElement;

import static context.DriverProvider.getAppiumDriver;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;
import static utils.GesturesUtils.swipeUp;

public class ProfilePage {

    public PostDetailPage openFirstPhoto() {
        int screenHeight = getAppiumDriver().manage().window().getSize().height;
        swipeUp((int) (screenHeight * 0.5), (int) (screenHeight * 0.3));
        MobileElement listOfPhotos = getAppiumDriver().findElement(id("android:id/list"));
        listOfPhotos.findElements(className("android.widget.ImageView")).get(0).click();
        return new PostDetailPage();
    }
}
