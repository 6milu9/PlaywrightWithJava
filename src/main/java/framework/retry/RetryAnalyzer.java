package framework.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int MAX = 0;

    @Override
    public boolean retry(ITestResult result) {
        return count++ < MAX;
    }
}
