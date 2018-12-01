package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegPage {
    private WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor ex;
    public String baseUrl = "https://www.wellrx.com/";

    public RegPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "hide-for-small-down")
    WebElement menu;
    @FindBy(id = "registerLink")
    WebElement register;

}

