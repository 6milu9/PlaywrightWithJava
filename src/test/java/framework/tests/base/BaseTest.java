package framework.tests.base;

import com.microsoft.playwright.Page;
import framework.config.ConfigLoader;
import framework.constants.ConfigKeys;
import framework.driver.PlaywrightFactory;
import framework.utils.WebUI;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners({
        AllureTestNg.class
})
public class BaseTest {
    protected PlaywrightFactory factory;
    protected static ThreadLocal<Page> page = new ThreadLocal<>();

    public static Page getPage() {
        return page.get();
    }

    @BeforeMethod
    public void setUp() {
        factory = new PlaywrightFactory();
        factory.start();
        WebUI.navigate(ConfigLoader.get(ConfigKeys.BASE_URL));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            factory.stopTracing(result.getName());
        }
        if (factory != null) {
            factory.close();
        }
    }
}
