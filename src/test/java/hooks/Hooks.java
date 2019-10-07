package hooks;

import context.DataProvider;
import context.DriverProvider;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) throws IOException {
        DriverProvider.initializeDriver(scenario);
        DataProvider.initializeUsers();
    }
}
