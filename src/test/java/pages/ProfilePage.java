package pages;

import static context.TestBase.getAppiumDriver;
import static utils.GesturesUtils.swipeUp;

public class ProfilePage {

    public PhotoDetailPage openPhoto() throws InterruptedException {
        swipeUp();
        Thread.sleep(500);
        getAppiumDriver()
            .findElementByAccessibilityId("Photo by Martin Skarbala at Row 1, Column 1")
            .click();
        return new PhotoDetailPage();
    }
}
