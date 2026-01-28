package framework.constants;

public class ConfigKeys {

    private ConfigKeys() {
        // prevent instantiation
    }

    // Timeouts
    public static final int DEFAULT_TIMEOUT = 30;
    public static final int SHORT_TIMEOUT = 5;
    public static final int LONG_TIMEOUT = 60;


    // Paths
    public static final String TRACE_DIR = "traces/";
    public static final String VIDEO_DIR = "videos/";
    public static final String SCREENSHOT_DIR = "screenshots/";

    // Retry
    public static final int MAX_RETRY_COUNT = 2;

    //Running environment
    public static final String QA = "qa";
    public static final String UAT = "uat";
    public static final String PROD = "prod";


    //Key
    public static final String BASE_URL = "baseUrl";
    public static final String BROWSER = "browser";
    public static final String HEADLESS = "headless";
    public static final String TIMEOUT = "timeout";
    public static final String API_BASE_URL = "api.baseUrl";
    public static final String ENV = "env";
}
