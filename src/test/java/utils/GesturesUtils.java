package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import static context.TestBase.getAppiumDriver;

public class GesturesUtils {

    public static void swipeUp() {
        new TouchAction(getAppiumDriver())
            .press(PointOption.point(100, 800))
            .moveTo((PointOption.point(100, 300)))
            .release()
            .perform();
    }
}
