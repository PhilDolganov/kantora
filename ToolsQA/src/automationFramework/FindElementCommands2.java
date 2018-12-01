package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementCommands2 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://toolsqa.wpengine.com/automation-practice-form");
        driver.findElement(By.partialLinkText("Partial")).click();
        System.out.println("Partial Link Test Pass");

        String sClass = driver.findElements(By.tagName("button")).toString();
        System.out.println(sClass);
        driver.findElement(By.linkText("Link Test")).click();
        System.out.println("Link Test Pass");
    }


}
