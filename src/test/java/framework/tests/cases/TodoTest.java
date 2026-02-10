package framework.tests.cases;

import framework.tests.base.BaseTest;
import framework.tests.pages.ToDoPage;
import framework.retry.RetryAnalyzer;
import framework.utils.JsonDataReader;
import framework.utils.StepExecutor;
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
    public void loginTest(Map<String, String> data) {
        ToDoPage page = new ToDoPage();
        StepExecutor.step("Create new task", () -> page.addNew(data.get("task")));
        System.out.println("TEST EXECUTED");
        Assert.assertTrue(true);
        Assert.fail();
    }
}
