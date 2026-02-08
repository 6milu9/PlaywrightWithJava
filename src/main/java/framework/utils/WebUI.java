package framework.utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import framework.constants.ConfigKeys;
import framework.constants.SelectorType;
import framework.driver.DriverManager;

public final class WebUI {
    private WebUI() {}

    private static Page page() {
        Page page = DriverManager.get();
        if (page == null) {
            throw new IllegalStateException("Page is not initialized");
        }
        return page;
    }

    private static void validate(String value, String name) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(name + " must not be null or blank");
        }
    }

    public static void navigate(String url) {
        validate(url, ConfigKeys.TYPE_URL);
        page().navigate(url);
    }

    private static Locator getElement(SelectorType selectorType, String selector) {
        validate(selector, ConfigKeys.TYPE_SELECTOR);
        switch (selectorType) {
            case ROLE:
                return page().getByRole(AriaRole.valueOf(selector));

            case TEXT:
                return page().getByText(selector);

            case LABEL:
                return page().getByLabel(selector);

            case PLACEHOLDER:
                return page().getByPlaceholder(selector);

            case ALTTEXT:
                return page().getByAltText(selector);

            case TITLE:
                return page().getByTitle(selector);

            case TESTID:
                return page().getByTestId(selector);

            case CSS:
                return page().locator("css=" + selector);

            case XPATH:
                return page().locator("xpath=" + selector);

            default:
                throw new IllegalArgumentException(
                        "Invalid selector type: " + selectorType + "."
                );
        }

    }

    public static void click(SelectorType selectorType, String selector) {
        getElement(selectorType, selector).click();
    }

    public static void type(SelectorType selectorType, String selector, String text) {
        getElement(selectorType, selector).fill(text);
    }

    public static String getText(SelectorType selectorType, String selector) {
        return getElement(selectorType, selector).textContent();
    }
}
