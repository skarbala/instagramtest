package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

import static context.TestBase.getAppiumDriver;

public class GesturesUtils {

    public static void swipeUp() {
        new TouchAction(getAppiumDriver())
            .press(PointOption.point(100, 800))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
            .moveTo((PointOption.point(100, 300)))
            .release()
            .perform();
    }

    public static void swipeLeft(int xOffsetStart, int xOffsetEnd, int yOffset) {
        new TouchAction(getAppiumDriver())
            .press(PointOption.point(xOffsetStart, yOffset))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
            .moveTo((PointOption.point(xOffsetEnd, yOffset)))
            .release()
            .perform();
    }


}
