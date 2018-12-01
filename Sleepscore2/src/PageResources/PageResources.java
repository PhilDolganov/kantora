package PageResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageResources {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    public PageResources(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }
    public LoginPage getLoginPage() {
        return loginPage = new LoginPage(driver);
    }//login page
    public DashboardPage getDashboardPage() {return dashboardPage = new DashboardPage(driver); }// dashboard page
}
