package context;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverProvider {

    public static AndroidDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    public static void initializeDriver(Scenario scenario) throws MalformedURLException {
        appiumDriver = initializeLocalDriver();
        WebDriverRunner.setWebDriver(appiumDriver);
    }

    private static AndroidDriver appiumDriver;

    private static AndroidDriver initializeLocalDriver() throws MalformedURLException {
        return new AndroidDriver(
            new URL("http://127.0.0.1:4723/wd/hub"),
            getAndroidCapabilitiesKiwi()
        );
    }

    private static AndroidDriver initializeBsDriver(Scenario scenario) throws MalformedURLException {
        return new AndroidDriver(
            getBsUrl(),
            getAndroidCapabilitiesBs(scenario));
    }

    private static DesiredCapabilities getAndroidCapabilitiesInstagram() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MI");
        capabilities.setCapability(MobileCapabilityType.UDID, "9bc5d6aa0704");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");

        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.scenarios.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
            "com.scenarios.android.activity.MainTabActivity"
        );
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        return capabilities;
    }

    private static DesiredCapabilities getAndroidCapabilitiesKiwi() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MI");
        capabilities.setCapability(MobileCapabilityType.UDID, "9bc5d6aa0704");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");

        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.skypicker.main");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
            "com.trinerdis.skypicker.activity.initialization.SplashActivity"
//            "com.trinerdis.skypicker.activity.initialization.DeepLinkActivity"
        );
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        return capabilities;
    }

    private static DesiredCapabilities getAndroidCapabilitiesBs(Scenario scenario) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        capabilities.setCapability(
            MobileCapabilityType.APP,
            "bs://15dc0ab061271e0db2101f3736f325b990369d98"
        );
        capabilities.setCapability(
            AndroidMobileCapabilityType.APP_PACKAGE,
            "com.scenarios.android"
        );
        capabilities.setCapability(
            AndroidMobileCapabilityType.APP_ACTIVITY,
            "com.scenarios.android.activity.MainTabActivity"
        );
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("name", scenario.getName());
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        capabilities.setCapability("browserstack.debug", "true");
        capabilities.setCapability("browserstack.appium_version", "1.12.1");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);


        return capabilities;
    }

    private static URL getBsUrl() throws MalformedURLException {
        return new URL("https://USERNAME:USERACCESSKEY@hub-cloud.browserstack.com/wd/hub");
    }

    private static DesiredCapabilities getAndroidChromeCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MI");
        capabilities.setCapability(MobileCapabilityType.UDID, "9bc5d6aa0704");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);

        return capabilities;
    }
}
