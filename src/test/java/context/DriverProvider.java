package context;

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

    public static void initializeDriver() throws MalformedURLException {
        appiumDriver = initializeLocalDriver();
    }

    private static AndroidDriver appiumDriver;

    private static AndroidDriver initializeLocalDriver() throws MalformedURLException {
        return new AndroidDriver(
            new URL("http://127.0.0.1:4723/wd/hub"),
            getAndroidCapabilities()
        );
    }

    private AndroidDriver initializeBsDriver() throws MalformedURLException {
        return new AndroidDriver(
            getBsUrl(),
            getAndroidCapabilitiesBs());
    }

    private static DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MI");
        capabilities.setCapability(MobileCapabilityType.UDID, "9bc5d6aa0704");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");

        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.instagram.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
            "com.instagram.android.activity.MainTabActivity"
        );

        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);


        return capabilities;
    }

    private static DesiredCapabilities getAndroidCapabilitiesBs() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Nexus 6");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        capabilities.setCapability(
            MobileCapabilityType.APP,
            "bs://d51e5b016e08014d8a99dae00be1f10c1be5dcaf"
        );
        capabilities.setCapability(
            AndroidMobileCapabilityType.APP_PACKAGE,
            "com.instagram.android"
        );
        capabilities.setCapability(
            AndroidMobileCapabilityType.APP_ACTIVITY,
            "com.instagram.android.activity.MainTabActivity"
        );
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        capabilities.setCapability("browserstack.debug", "true");
        capabilities.setCapability("browserstack.appium_version", "1.12.1");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);


        return capabilities;
    }

    private URL getBsUrl() throws MalformedURLException {
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
