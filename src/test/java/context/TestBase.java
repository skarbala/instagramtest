package context;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
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
        appiumDriver = new AndroidDriver(
            new URL("http://127.0.0.1:4723/wd/hub"),
            getAndroidCapabilities());
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
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


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
}
