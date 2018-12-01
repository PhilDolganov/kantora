package executeFailedTests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
    int counter = 0, retryCount = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (counter < retryCount){
            counter++;
            return true;
        }
        return false;
    }
}
