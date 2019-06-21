package hooks;

import context.DataProvider;
import context.TestBase;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks {

    @Before
    public void setUp() throws IOException {
        TestBase.initializeDriver();
        DataProvider.initializeUsers();
    }
}
