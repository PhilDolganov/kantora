package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageResources {
    WebDriver driver;
    WebDriverWait wait;
    //LoginPage loginPage;
    RegPage regPage;

    public PageResources(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }
    public RegPage getRegPage() {
        return regPage = new RegPage(driver);
    }//registration page
}
