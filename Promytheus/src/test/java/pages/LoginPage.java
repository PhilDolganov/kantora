package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='email']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement userpassword;
    @FindBy(id = "login")
    WebElement loginButton;
    public void enterUsername(String email){
        username.sendKeys(email);
    }
    public void enterPassword(String password){
        userpassword.sendKeys(password);
    }
    public void pushLoginButton(){
        loginButton.click();
    }
}

