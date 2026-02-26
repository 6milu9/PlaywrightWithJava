package framework.enums;

public enum BrowserName {
    CHROMIUM("chromium"),
    FIREFOX("firefox"),
    WEBKIT("webkit");

    private final String value;

    BrowserName(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static BrowserName from(String type) {
        for (BrowserName val : values()) {
            if (val.value.equalsIgnoreCase(type)) {
                return val;
            }
        }
        throw new IllegalArgumentException("Invalid browser type: " + type + ". Accept only: chrome, firefox, safari");
    }
}