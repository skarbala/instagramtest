package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

import static context.DriverProvider.getAppiumDriver;

public class GesturesUtils {

    public static void swipeVertically(int yOffsetStart, int yOffsetEnd) {
        new TouchAction(getAppiumDriver())
            .press(PointOption.point(100, yOffsetStart))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
            .moveTo((PointOption.point(100, yOffsetEnd)))
            .release()
            .perform();
    }

    public static void swipeHorizontally(int xOffsetStart, int xOffsetEnd, int yOffset) {
        new TouchAction(getAppiumDriver())
            .press(PointOption.point(xOffsetStart, yOffset))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
            .moveTo((PointOption.point(xOffsetEnd, yOffset)))
            .release()
            .perform();
    }


}
