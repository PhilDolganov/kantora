package basic;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Login {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,5);
        baseUrl = "http://hrm.seleniumminutes.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test() {

        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("Password");
        driver.findElement(By.cssSelector("#btnLogin")).click();
        String actualWelcome = driver.findElement(By.cssSelector("#welcome")).getText();
        assertEquals("Welcome Admin", actualWelcome);

        driver.findElement(By.className("quickLinkText")).getText();
        // OTHER WAY
        driver.findElement(By.cssSelector("span.quickLinkText")).getText();
        // OTHER WAY
        driver.findElement(By.xpath("//span[@class='quickLinkText']")).getText();

        // Now we are looking for the first img tag in the quickLaunge
        driver.findElement(By.xpath("//span[@class='quickLaunge']/a/img")).getAttribute("src");
        // OTHER WAY
        driver.findElement(By.xpath("//div[@id='dashboard-quick-launch-panel-menu_holder']//img")).getAttribute("src");
        // OTHER WAY
        driver.findElement(By.id("dashboard-quick-launch-panel-menu_holder")).findElement(By.tagName("img")).getAttribute("src");

        // find the label and then img above
        driver.findElement(By.cssSelector("span.quickLinkText")).findElement(By.xpath(".//../img")).getAttribute("src");

    }
    private void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
          //  TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
