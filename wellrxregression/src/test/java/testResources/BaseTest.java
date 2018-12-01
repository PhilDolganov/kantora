package testResources;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import pages.PageResources;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl;
    public PageResources pageResources;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        pageResources = new PageResources(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        baseUrl = "https://www.wellrx.com/";
        driver.get(baseUrl);//go to home page
    }
    @Test
    public  void main(){
        //driver.get(baseUrl);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hide-for-small-down")));
        driver.findElement(By.className("hide-for-small-down")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerLink"))).click();

    }
}


