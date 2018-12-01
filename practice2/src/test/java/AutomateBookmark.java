import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AutomateBookmark {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com");

        driver.findElement(By.id("lst-ib")).sendKeys("russia");
        driver.findElement(By.cssSelector("input.lsb")).click();
       Thread.sleep(5000);
       Actions actions = new Actions(driver);

        String bookmark = Keys.chord(Keys.CONTROL,"d");
       driver.findElement(By.xpath("//a[contains(text(), 'Russia - Wikipedia')]")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
//        Actions bookmark = new Actions(driver);
//        bookmark.contextClick(driver.findElement(By.xpath("//a[contains(text(), 'Russia - Wikipedia')]"))).sendKeys("m").perform();

//        Actions action = new Actions(driver);
//        action.keyDown(Keys.CONTROL).sendKeys("d").keyUp(Keys.CONTROL).perform();

//        String bookmark = Keys.chord(Keys.CONTROL,"a");
//        String url = "https://en.wikipedia.org/wiki/Russia";
//        driver.get(url);
//        driver.findElement()

    }
}