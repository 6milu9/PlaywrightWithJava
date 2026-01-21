package framework.driver;

import com.microsoft.playwright.Page;

public class DriverManager {
    private static final ThreadLocal<Page> page = new ThreadLocal<>();

    public static void set(Page p) {
        page.set(p);
    }

    public static Page get() {
        return page.get();
    }

    public static void unload() {
        page.remove();
    }
}
