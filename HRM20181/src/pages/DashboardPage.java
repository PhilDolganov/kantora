package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public String getWelcomeMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#welcome"))).getText();
         
        
    }

    public void logout() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#welcome"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout"))).click();
    }
}
