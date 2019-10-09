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
    
    private static final String BS_USER = "USER";
    private static final String BS_PASSWORD = "PASSWORD";
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

    private static AndroidDriver buildBrowserstackKiwiDriver(Scenario scenario) throws MalformedURLException {
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

        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.instagram.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
            "com.instagram.android.activity.MainTabActivity"
        );

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
            "bs://3584ee2c3af9e958e14a23b730749ddb44e866d1"
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
        String url = String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", BS_USER, BS_PASSWORD);
        return new URL(url);
    }

}
