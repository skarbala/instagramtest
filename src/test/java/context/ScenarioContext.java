package context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private static ScenarioContext scenarioContext;
    private static Map<String, Object> contextMap;

    private ScenarioContext() {
        contextMap = new HashMap<>();
    }

    public void setContext(Context key, Object value) {
        contextMap.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return contextMap.get(key.toString());
    }

    public static ScenarioContext getInstance() {
        if (scenarioContext == null) {
            scenarioContext = new ScenarioContext();
        }
        return scenarioContext;
    }

}
