package hooks.instagram;

import java.io.IOException;

import context.DriverProvider;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void setUp() throws IOException {
        DriverProvider.initializeLocalInstagramDriver();
    }

    @After
    public void tearDown() {
        DriverProvider.getAppiumDriver().quit();
    }
}
