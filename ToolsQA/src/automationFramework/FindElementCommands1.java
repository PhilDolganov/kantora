package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementCommands1 {
    public static void main(String[] args){
        String url = "http://toolsqa.wpengine.com/automation-practice-form";
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        driver.findElement(By.name("firstname")).sendKeys("Portnov");
        driver.findElement(By.name("lastname")).sendKeys("Test");
        driver.findElement(By.id("submit")).click();
    }
}
