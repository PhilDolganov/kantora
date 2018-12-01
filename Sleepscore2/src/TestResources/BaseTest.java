package TestResources;

import PageResources.PageResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PageResources pageResources;

    @BeforeClass
    public void baseSetUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageResources = new PageResources(driver);
    }
    @AfterClass
    public void baseTearDown(){
        driver.quit();
    }
}
