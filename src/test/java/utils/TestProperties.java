package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    private static TestProperties instance;
    private Properties properties;

    public TestProperties() {
        loadProperties();
    }

    public static TestProperties getInstance() {
        if (instance == null) {
            instance = new TestProperties();
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().getProperty("ig.password"));
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    private void loadProperties() {
        try {
            InputStream input = new FileInputStream("src/test/resources/test.properties");
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
