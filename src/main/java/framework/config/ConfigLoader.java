package framework.config;

import framework.constants.ConfigKeys;
import framework.constants.RunningEnvironment;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigLoader {
    private static final Properties props = new Properties();
    private static final RunningEnvironment ENV;

    static {
        String envValue = System.getProperty(ConfigKeys.ENV, RunningEnvironment.QA.value());
        ENV = RunningEnvironment.from(envValue);
        String fileName = ENV.value() + ".properties";

        try (InputStream is = ConfigLoader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (is == null) {
                throw new RuntimeException(
                        "Could not find " + fileName + " in classpath");
            }
            props.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    private ConfigLoader() {
        // prevent instantiation
    }

    public static String get(String key) {
        return System.getProperty(key, props.getProperty(key));
    }
}
