package hooks.instagram;

import context.DataProvider;
import context.DriverProvider;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks {

    @Before
    public void setUp() throws IOException {
        DriverProvider.initializeLocalInstagramDriver();
        DataProvider.initializeUsers();
    }

    @After
    public void tearDown() {
        DriverProvider.getAppiumDriver().quit();
    }
}
