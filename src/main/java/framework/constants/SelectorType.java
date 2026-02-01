package framework.constants;

public enum SelectorType {
    ROLE("role"),
    TEXT("text"),
    LABEL("label"),
    PLACEHOLDER("placeholder"),
    ALTTEXT("alttext"),
    TITLE("title"),
    TESTID("testid"),
    XPATH("xpath"),
    CSS("css");

    private final String type;

    SelectorType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }

    public static SelectorType from(String type) {
        for (SelectorType val : values()) {
            if (val.type.equalsIgnoreCase(type)) {
                return val;
            }
        }
        throw new IllegalArgumentException(
                "Invalid selector type: " + type + "."
        );
    }
}
