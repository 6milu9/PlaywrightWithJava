package framework.report;

import com.microsoft.playwright.Page;
import framework.tests.base.BaseTest;
import io.qameta.allure.Allure;
import org.testng.*;

import java.io.ByteArrayInputStream;

public class AllureListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("=== Test Execution Started ===");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Allure.step("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        Allure.step("Test Failed: " + result.getThrowable().getMessage());

        try {
            attachScreenshot(result.getMethod().getMethodName());
        } catch (Exception e) {
            Allure.step("Failed to attach screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Allure.step("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("=== Test Execution Finished ===");
    }

    /**
     * Capture screenshot using Playwright and attach to Allure
     */
    private void attachScreenshot(String testName) throws Exception {

        Page page = BaseTest.getPage();


        if (page == null) {
            return;
        }

        byte[] screenshot = page.screenshot(
                new Page.ScreenshotOptions().setFullPage(true)
        );

        Allure.addAttachment(
                testName + " - Screenshot",
                new ByteArrayInputStream(screenshot)
        );
    }
}