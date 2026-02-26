package framework.report;

import com.microsoft.playwright.Page;
import framework.enums.Status;
import framework.logging.LogHandler;
import framework.tests.base.BaseTest;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

public class AllureLogHandler implements LogHandler {

    @Override
    public void log(Status status, String message) {

    }

    @Override
    public void logWithScreenShot(Status status, String message, String testName) {
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
