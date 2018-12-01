package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String pageUrl = "http://hrm.seleniumminutes.com";

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new  WebDriverWait(driver, 5);
    }
    public void load(){
        driver.get(pageUrl);
    }

    public String getHeader() {
        By header = By.cssSelector(".head > h1");
        return driver.findElement(header).getText();
    }
}
