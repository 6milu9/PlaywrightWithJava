package framework.utils;

import io.qameta.allure.Allure;

public class StepExecutor {

    private StepExecutor() {}

    public static void step(String name, Runnable action) {
        Allure.step(name);
        try {
            action.run();
        } catch (Throwable t) {
            Allure.step("❌ Step failed: " + t.getMessage());
            throw t;
        }
    }
}
