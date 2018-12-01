package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PracticeTables {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://toolsqa.wpengine.com/automation-practice-table");
        String sCellValue = driver.findElement(By.xpath("//*[@class='tsc_table_s13']//tbody/tr[1]/td[2]")).getText();
        System.out.println(sCellValue);
        driver.findElement(By.xpath("//*[@class='tsc_table_s13']//tbody/tr[1]/td[6]")).click();
        System.out.println("Link has been clicked otherwise an exception would have been thrown");
        driver.close();
    }
}
