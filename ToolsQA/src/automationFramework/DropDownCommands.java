package automationFramework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownCommands {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://toolsqa.wpengine.com/automation-practice-form");
        Select continents = new Select(driver.findElement(By.id("continents")));
        continents.selectByIndex(1);
        continents.selectByVisibleText("Africa");
        List<WebElement> elementCount = continents.getOptions();
        int iSize = elementCount.size();
        for (int i = 0; i < iSize; i++){
            String sValue = elementCount.get(i).getText();
            System.out.println(sValue);
            if (sValue.equals("Africa")){
                continents.selectByIndex(i);
                break;
            }
        }

        for (WebElement continent : continents.getOptions())
            System.out.println(continent.getText());
        driver.quit();

    }
}
