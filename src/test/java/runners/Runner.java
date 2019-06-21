package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/scenarios/",
    glue = {"steps", "hooks"},
    junit = "--step-notifications"
)
public class Runner {

}
