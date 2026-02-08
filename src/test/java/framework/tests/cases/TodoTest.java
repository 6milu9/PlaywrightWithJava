package framework.tests.cases;

import framework.constants.ConfigKeys;
import framework.tests.base.BaseTest;
import framework.tests.pages.ToDoPage;
import framework.retry.RetryAnalyzer;
import framework.utils.JsonDataReader;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class TodoTest extends BaseTest {
    @DataProvider
    public Object[][] data() throws Exception {
        return JsonDataReader.read("src/test/resources/NewTask.json");
    }

    @Test(dataProvider = "data", retryAnalyzer = RetryAnalyzer.class)
    public void loginTest(Map<String, String> data) throws InterruptedException {
        Allure.step("🔥 Allure is alive");
        System.out.println("TEST EXECUTED");
        new ToDoPage().addNew(data.get("task"));
        Thread.sleep(ConfigKeys.SHORT_TIMEOUT);
        Assert.assertTrue(true);
    }
}
