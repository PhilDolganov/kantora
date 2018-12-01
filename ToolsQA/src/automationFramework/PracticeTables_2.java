package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PracticeTables_2 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://toolsqa.wpengine.com/automation-practice-table");
        String sRow = "1";
        String sCol = "2";
        String sCellValue = driver.findElement(By.xpath("//*[@class='tsc_table_s13']//tbody/tr[" + sRow + "]/td[" + sCol + "]")).getText();
        System.out.println(sCellValue);
        String sRowValue = "Clock Tower Hotel";
        for (int i = 1; i < 5; i++) {
            String sValue = driver.findElement(By.xpath("//*[@class='tsc_table_s13']//tbody//tr[" + i +"]/th")).getText();
            if (sValue.equalsIgnoreCase(sRowValue)){
                for (int j = 1; j <= 5; j++) {
                    String sColumnValue = driver.findElement(By.xpath("//*[@class='tsc_table_s13']//tbody/tr[" + i + "]/td[" + j + "]")).getText();
                    System.out.println(sColumnValue);
                }
                break;
            }
        }
        driver.close();
    }
}
