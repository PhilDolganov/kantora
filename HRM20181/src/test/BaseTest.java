package test;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;


    @Before
    public void baseSetUp() throws Exception {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,5);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void baseTearDown() throws Exception {
        //takeScreenshot("myScreenshot.png");
        driver.quit();
    }

    private void takeScreenshot(String fileName) throws IOException {
        TakesScreenshot tst = (TakesScreenshot)driver;
        File tmpFile = tst.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileName);
        FileUtils.copyFile(tmpFile, destFile);
    }
}
