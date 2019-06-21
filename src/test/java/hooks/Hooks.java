package hooks;

import context.DataProvider;
import context.DriverProvider;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks {

    @Before
    public void setUp() throws IOException {
        DriverProvider.initializeDriver();
        DataProvider.initializeUsers();
    }
}
