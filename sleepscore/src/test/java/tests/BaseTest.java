package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
       // driver.quit();
    }
}
