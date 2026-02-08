package framework.tests.base;

import framework.config.ConfigLoader;
import framework.constants.ConfigKeys;
import framework.driver.PlaywrightFactory;
import framework.utils.WebUI;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected PlaywrightFactory factory;

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
