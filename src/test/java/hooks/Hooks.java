package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestLogger;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        TestLogger.log("------------------------------------------------------------");
        TestLogger.log("STARTING SCENARIO: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        String status = scenario.isFailed() ? "FAILED" : "PASSED";
        TestLogger.log("SCENARIO '" + scenario.getName() + "' " + status);
        TestLogger.log("------------------------------------------------------------\n");
    }
}
