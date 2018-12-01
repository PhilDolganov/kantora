package PageResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseURL = "https://portal-systest.azurewebsites.net";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "loginInputEmail")
    WebElement emailField;
    @FindBy(id = "loginInputPassword")
    WebElement passwordField;
    @FindBy(css = "#form-login > button")
    WebElement loginButton;

    public void loadLoginPage(){
        driver.get(baseURL);
    }

    public void enterUsername(String email) {
        emailField.sendKeys(email);
    }
    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }
    public void pushLoginButton() {
        loginButton.click();
    }


}
