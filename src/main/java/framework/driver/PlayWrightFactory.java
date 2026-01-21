package framework.driver;

import com.microsoft.playwright.*;
import framework.config.ConfigLoader;

import java.nio.file.Paths;

public class PlayWrightFactory {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;

    public void start() {
        BrowserName browserName;
        BrowserType browserType;

        playwright = Playwright.create();
        boolean headless = Boolean.parseBoolean(ConfigLoader.get("headless"));

        try {
            browserName = BrowserName.valueOf(ConfigLoader.get("browser").toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid browser in properties file", e);
        }

        browserType = switch (browserName) {
            case CHROMIUM -> playwright.chromium();
            case FIREFOX -> playwright.firefox();
            case WEBKIT -> playwright.webkit();
        };

        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));

        context = browser.newContext();

        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
        );

        Page page = context.newPage();
        DriverManager.set(page);
    }

    public void stopTracing(String name) {
        context.tracing().stop(
                new Tracing.StopOptions()
                        .setPath(Paths.get("traces/" + name + ".zip"))
        );
    }

    public void close() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
