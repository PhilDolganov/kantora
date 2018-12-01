package basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class ChatUsing2Sessions {
    private String baseUrl = "https://www.cometchat.com/demo";
    private WebDriver chat1;
    private WebDriver chat2;
    private WebDriverWait wait;
    private WebDriverWait wait2;

    @Before
    public void setUp() throws Exception {
        chat1 = new FirefoxDriver();
        chat1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(chat1, 5);

        chat2 = new ChromeDriver();
        chat2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait2 = new WebDriverWait(chat1, 5);
    }
//    @After
//    public void tearDown() throws Exception {
//        chat1.quit();
//        chat2.quit();
//    }
    @Test
    public void test() {
        chat1.get(baseUrl);
 //       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fresno-no-button"))).click();
        chat1.switchTo().frame(chat1.findElement(By.id("cometchat_synergy_iframe")));
        String userId = chat1.findElement(By.id("cometchat_welcome_username")).getText();

        chat2.get(baseUrl);
 //       wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("fresno-no-button"))).click();
        chat2.switchTo().frame(chat2.findElement(By.id("cometchat_synergy_iframe")));
        chat2.findElement(By.id("cometchat_user_search")).clear();
        chat2.findElement(By.id("cometchat_user_search")).sendKeys(userId);

        chat2.findElement(By.cssSelector(".cometchat_userlist[style='display: block;']")).click();
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("cometchat_textarea"))).click();
        chat2.findElement(By.className("cometchat_textarea")).sendKeys("Hello from WebDriver chat 2");
    }
}
