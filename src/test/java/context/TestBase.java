package context;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class TestBase {

    public static AndroidDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    private static AndroidDriver appiumDriver;
    private List<User> users;

    @BeforeMethod
    public void setUp() throws IOException {
        initializeUsers();
        appiumDriver = initializeLocalDriver();
    }

    private AndroidDriver initializeLocalDriver() throws MalformedURLException {
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
        capabilities.setCapability(
            AndroidMobileCapabilityType.APP_PACKAGE,
            "com.instagram.android"
        );
        capabilities.setCapability(
            AndroidMobileCapabilityType.APP_ACTIVITY,
            "com.instagram.android.activity.MainTabActivity"
        );
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
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

    private void initializeUsers() throws IOException {
        users = Arrays.asList(new ObjectMapper()
            .readValue(new File("src/test/resources/users.json"), User[].class));
    }

    protected User getUser(String userName) {
        return users.stream()
            .filter(user -> user.getUserName().equals(userName))
            .findFirst()
            .orElseThrow(NullPointerException::new);
    }

    private URL getBsUrl() throws MalformedURLException {
        return new URL("https://cardlaybrowserst1:YpMDmUpyq11s6GnbzTmH@hub-cloud.browserstack.com/wd/hub");

    }
}
