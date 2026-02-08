package framework.api;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

public class ApiManager {
    private static APIRequestContext context;

    private ApiManager() {}

    public static void init(String baseUrl) {
        Playwright playwright = Playwright.create();
        context = playwright.request().newContext(
                new APIRequest.NewContextOptions()
                        .setBaseURL(baseUrl)
        );
    }

    public static APIRequestContext get() {
        return context;
    }

    public static void close() {
        if (context != null) context.dispose();
    }
}
