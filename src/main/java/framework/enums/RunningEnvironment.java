package framework.enums;

public enum RunningEnvironment {
    QA("qa"),
    UAT("uat"),
    PROD("prod");

    private final String value;

    RunningEnvironment(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static RunningEnvironment from(String env) {
        for (RunningEnvironment type : values()) {
            if (type.value.equalsIgnoreCase(env)) {
                return type;
            }
        }
        throw new IllegalArgumentException(
                "Invalid environment: " + env + ". Supported values: qa, uat, prod"
        );
    }
}
