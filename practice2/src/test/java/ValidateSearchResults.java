import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ValidateSearchResults {

    public static void main(String[] args) throws InterruptedException {
        // First, let's declare our search term
        String searchTerm = "Selenium";

        // Then, let's start our WebDriver and navigate to google
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();

        // Next, we'll execute the search
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        //WebElement searchButton = driver.findElement(By.name("btnK"));
        //searchButton.click();
        Thread.sleep(5000);
        // Now, let's gather our search results
        List<WebElement> results = driver.findElements(By.cssSelector("h3 > a"));

        // Finally, we'll loop over the list to verify each result link contains our term
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getText().contains(searchTerm))
           System.out.println(results.get(i).getText());
        }
    }
}
