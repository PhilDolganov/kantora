package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultiSelectCommands {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://toolsqa.wpengine.com/automation-practice-form");
        Select seleniumCommands = new Select(driver.findElement(By.name("selenium_commands")));
        seleniumCommands.selectByIndex(0);
        seleniumCommands.deselectByIndex(0);
        seleniumCommands.selectByVisibleText("Navigation Commands");
        seleniumCommands.deselectByVisibleText("Navigation Commands");
        for (WebElement seleniumOptions : seleniumCommands.getOptions())
        System.out.println(seleniumOptions.getText());

        int sizeOptions = seleniumCommands.getOptions().size();
        for (int i = 0; i < sizeOptions; i++){
            seleniumCommands.selectByIndex(i);
        }
        seleniumCommands.deselectAll();

        // ToolsQA solution for step 6:
        List<WebElement> oSize = seleniumCommands.getOptions();
        int iListSize = oSize.size();
        for (int i = 0; i < iListSize; i++){
            String sValue = seleniumCommands.getOptions().get(i).getText();
            System.out.println(sValue);
            seleniumCommands.selectByIndex(i);
        }
        driver.quit();
    }
}
