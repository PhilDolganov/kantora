package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='email']")
    public//login field
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")//password field
    WebElement userpassword;
    @FindBy(id = "login")//login button
    WebElement loginButton;
    public void enterUsername(String email){
        username.sendKeys(email);
    }//enter user login
    public void enterPassword(String password){
        userpassword.sendKeys(password);
    }
    public void pushLoginButton(){
        loginButton.click();
    }
}//enter user password and push login button
