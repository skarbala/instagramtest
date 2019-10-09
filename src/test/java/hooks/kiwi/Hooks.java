package hooks.kiwi;

import context.DataProvider;
import context.DriverProvider;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) throws IOException {
        DriverProvider.initializeBrowserstackKiwiDriver(scenario);
    }

    @After
    public void tearDown() {
        DriverProvider.getAppiumDriver().quit();
    }
}
