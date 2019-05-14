import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class InstagramTest {

    @Test
    public void testLogIn() throws MalformedURLException, InterruptedException {
        AppiumDriver appiumDriver = new AppiumDriver(
            new URL("http://127.0.0.1:4723/wd/hub"),
            getAndroidCapabilities());

        appiumDriver.findElement(By.id("log_in_button")).click();
        appiumDriver.findElement(By.id("login_username")).sendKeys("furbo.slav");
        appiumDriver.findElement(By.id("password")).sendKeys("Ma31ra08");
        appiumDriver.findElement(By.id("button_text")).click();
        new WebDriverWait(appiumDriver, 10)
            .until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@content-desc='Profile']")));
        Thread.sleep(1000);
        appiumDriver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='Profile']"))
            .click();
        Thread.sleep(1000);
        new WebDriverWait(appiumDriver, 10)
            .until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='Profile Photo']")));
        new TouchAction(appiumDriver)
            .press(PointOption.point(100, 800))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
            .moveTo((PointOption.point(100, 200)))
            .release()
            .perform();
        Thread.sleep(1000);
        appiumDriver
            .findElement(By.xpath("//android.widget.ImageView[@content-desc='Photo by Martin Skarbala at Row 1, Column 1']"))
            .click();
        Thread.sleep(1000);
        appiumDriver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Comment']")).click();
        appiumDriver.findElement(By.id("layout_comment_thread_edittext"))
            .sendKeys("meetup furbo + slido jesen 2019");
        appiumDriver.findElement(By.id("layout_comment_thread_post_button_click_area")).click();


    }

    private static DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MI");
        capabilities.setCapability(MobileCapabilityType.UDID, "9bc5d6aa0704");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        capabilities.setCapability(
            AndroidMobileCapabilityType.APP_PACKAGE,
            "com.instagram.android"
        );
        capabilities.setCapability(
            AndroidMobileCapabilityType.APP_ACTIVITY,
            "com.instagram.mainactivity.MainActivity"
        );
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        return capabilities;
    }
}

