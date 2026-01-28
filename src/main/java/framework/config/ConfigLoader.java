package framework.config;

import framework.constants.ConfigKeys;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigLoader {
    private static final Properties props = new Properties();

    static {
        String env = System.getProperty(ConfigKeys.ENV, ConfigKeys.QA);
        String fileName = env + ".properties";
        try (InputStream is =
                     ConfigLoader.class
                             .getClassLoader()
                             .getResourceAsStream(fileName)) {

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
