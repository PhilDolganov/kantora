package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegPage {
    private WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor ex;
    String baseUrl ="http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html";
    public RegPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Register Now')]")//registration button
    WebElement registerButton;
    @FindBy(id = "userType")//select user type
    WebElement userType;
    @FindBy(id ="signUpFirstName")//first name
    WebElement signUpFirstName;
    @FindBy(id ="signUpMiddleName")//middle name
    WebElement signUpmiddleName;
    @FindBy(id = "signUpLastName")//last name
    WebElement signUpLastName;
    @FindBy(id = "signUpCounty")//country
    WebElement signUpCounty;
    @FindBy(id = "signUpAddress")//address
    WebElement signUpAddress;
    @FindBy(id = "signUpPhone")//phone #
    WebElement signUpPhone;
    @FindBy(id = "signUpRegisterEmail")//email
    WebElement signUpRegisterEmail;
    @FindBy(id ="signUpRegisterPassword")//password
    WebElement signUpRegisterPassword;
    @FindBy(id = "signUpRegisterRePassword")//password retype
    WebElement signUpRegisterRePassword;
    @FindBy(id = "createAccount")//create account
    WebElement createAccount;
    @FindBy(css = "body > app > splash-screen > div")//app logo
    WebElement cover;
    public void pushRegisterNow() {
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        registerButton.click();
    }//push register
    public void checkScoutButton() throws InterruptedException {
        Thread.sleep(500);
        ex = (JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();",userType);
    }//select scout checkbox
    public void inputNames(String firstName, String middleName, String lastName) {
        signUpFirstName.sendKeys(firstName);
        signUpmiddleName.sendKeys(middleName);
        signUpLastName.sendKeys(lastName);
        }//enter first, middle,last names
    public void selectCountry(String country) {
        signUpCounty.sendKeys(country);
    }//select country
    public void inputAddress(String address) {
        signUpAddress.sendKeys(address);
    }//enter address
    public void inputPhone(String phone) {
        signUpPhone.sendKeys(phone);
    }//enter ph#
    public void inputEmail(String email) {
        signUpRegisterEmail.sendKeys(email);
    }//enter email
    public void inputPassword(String password) {
        signUpRegisterPassword.sendKeys(password);
        signUpRegisterRePassword.sendKeys(password);
    }//enter password
    public void pushCreateAccount() {
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();", createAccount);
    }//push create account button
    public void killCover(){
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].parentNode.removeChild(arguments[0]);",cover);
        System.out.println("Cover killed");
    }//close cover logo to prevent obstruction of web elements
}
