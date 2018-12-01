import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearch {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com");

        driver.findElement(By.id("lst-ib")).sendKeys("russia");

        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));
        System.out.println("total number of suggestions is " + list.size());
        int numberOfSuggestions = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().contains("russia")){
                System.out.println(list.get(i).getText());
                numberOfSuggestions++;
            }

//           if (list.get(i).getText().contains("testing")){
//               list.get(i).click();
//               break;
//         }
        }
        System.out.println(numberOfSuggestions);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input.lsb")).click();
        List<WebElement> links = driver.findElements(By.cssSelector("#rso h3 > a"));
        System.out.println("Number of search results: " + links.size());
        int actualresults = 0;
        for (int i = 0; i < links.size(); i++) {
            if (links.get(i).getText().contains("Russia")){
                System.out.println(links.get(i).getText());
                actualresults++;
            }
        }
        System.out.println(actualresults);
        driver.quit();
    }
}
