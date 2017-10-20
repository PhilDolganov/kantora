package testResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl;
    public PageResources pageResources;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new ChromeDriver();//instantiating chrome driver
        pageResources = new PageResources(driver);
        wait = new WebDriverWait(driver, 5);//explicit wait
        baseUrl = "file:///C:/Users/phild_000/IdeaProjects/octopus/src/test/java/testResources/testPage.html";//path to testPage.html
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//implicit wait
        driver.get(baseUrl);//go to home page

    }
    @AfterTest
    public void quit () throws Exception {
        driver.quit();//close browser after test
    }
}
