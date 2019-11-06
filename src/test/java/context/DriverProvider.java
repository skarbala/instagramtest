package context;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.WebDriverRunner;

import cucumber.api.Scenario;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.TestProperties;

public class DriverProvider {


    private static AndroidDriver appiumDriver;

    public static AndroidDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    public static void initializeLocalInstagramDriver() throws MalformedURLException {
        appiumDriver = buildLocalInstagramDriver();
        WebDriverRunner.setWebDriver(appiumDriver);
    }

    public static void initializeBrowserstackKiwiDriver(Scenario scenario) throws MalformedURLException {
        appiumDriver = buildBrowserstackKiwiDriver(scenario);
        WebDriverRunner.setWebDriver(appiumDriver);
    }


    private static AndroidDriver buildLocalInstagramDriver() throws MalformedURLException {
        return new AndroidDriver(
            new URL("http://127.0.0.1:4723/wd/hub"),
            getAndroidCapabilitiesInstagram()
        );
    }


    private static AndroidDriver buildLocalKiwiDriver() throws MalformedURLException {
        return new AndroidDriver(
            new URL("http://127.0.0.1:4723/wd/hub"),
            getAndroidCapabilitiesKiwi()
        );
    }

    private static AndroidDriver buildBrowserstackKiwiDriver(Scenario scenario) throws MalformedURLException {
        return new AndroidDriver(
            getBsUrl(),
            getAndroidCapabilitiesBs(scenario)
        );
    }

    private static DesiredCapabilities getAndroidCapabilitiesInstagram() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
            TestProperties.getInstance().getProperty("android.phone.name"));
        capabilities.setCapability(
            MobileCapabilityType.UDID,
            TestProperties.getInstance().getProperty("android.phone.id"));
        capabilities.setCapability(
            MobileCapabilityType.PLATFORM_NAME,
            TestProperties.getInstance().getProperty("android.phone.os")
        );
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
            TestProperties.getInstance().getProperty("android.phone.os.version"));

        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.instagram.android");
        capabilities.setCapability(
            AndroidMobileCapabilityType.APP_ACTIVITY,
            "com.instagram.android.activity.MainTabActivity"
        );
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        return capabilities;
    }


    private static DesiredCapabilities getAndroidCapabilitiesBs(Scenario scenario) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        capabilities.setCapability(
            MobileCapabilityType.APP,
            "bs://e89ab52d998a17f22006756710f5262cf11074de"
        );
        capabilities.setCapability(
            AndroidMobileCapabilityType.APP_PACKAGE,
            "com.skypicker.main"
        );
        capabilities.setCapability(
            AndroidMobileCapabilityType.APP_ACTIVITY,
            "com.trinerdis.skypicker.activity.initialization.SplashActivity"
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
        String url = String.format(
            "https://%s:%s@hub-cloud.browserstack.com/wd/hub",
            TestProperties.getInstance().getProperty("bs.user"),
            TestProperties.getInstance().getProperty("bs.password")
        );
        return new URL(url);
    }

    private static DesiredCapabilities getAndroidCapabilitiesKiwi() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MI");
        capabilities.setCapability(MobileCapabilityType.UDID, "1407c40b");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");

        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.skypicker.main");
        capabilities.setCapability(
            AndroidMobileCapabilityType.APP_ACTIVITY,
            "com.trinerdis.skypicker.activity.initialization.SplashActivity"
        );
        capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        return capabilities;
    }


}
