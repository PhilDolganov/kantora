package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBxRadioBtn {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://toolsqa.wpengine.com/automation-practice-form");
        List<WebElement> rdBtn_Sex = driver.findElements(By.name("sex"));
        boolean bValue = rdBtn_Sex.get(1).isSelected();
        if (bValue != true){
            rdBtn_Sex.get(1).click();
        } else {
            rdBtn_Sex.get(0).click();
        }
        WebElement rdBtn_Exp = driver.findElement(By.id("exp-2"));
        rdBtn_Exp.click();

        List<WebElement> chckBx_Profession = driver.findElements(By.name("profession"));
        int iSize = chckBx_Profession.size();
        for (int i = 0; i < iSize; i++){
            String sValue = chckBx_Profession.get(i).getAttribute("value");
            if (sValue.equalsIgnoreCase("Automation Tester")){
                chckBx_Profession.get(i).click();
                break;
            }
        }

        WebElement oCheckBox = driver.findElement(By.cssSelector("#tool-1[value='Selenium IDE']"));
        oCheckBox.click();
        driver.quit();
    }
}
