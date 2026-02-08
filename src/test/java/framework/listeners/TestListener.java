package framework.listeners;

import framework.driver.DriverManager;
import io.qameta.allure.Allure;
import org.testng.*;

import java.io.ByteArrayInputStream;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        byte[] screenshot = DriverManager.get().screenshot();
        Allure.addAttachment("Screenshot",
                new ByteArrayInputStream(screenshot));
    }
}