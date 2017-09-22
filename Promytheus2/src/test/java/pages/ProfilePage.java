package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    WebDriver driver;
    WebDriverWait wait;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//html//body//div//header//nav//div[2]//ul[2]//li[2]")//profile web element
    WebElement profileIcon;
    @FindBy(xpath = "//p[contains(text(), 'My Profile')]")//my profile web element
    WebElement myProfile;
    @FindBy(xpath = "//p[contains(text(), 'Sign Out')]")//sign out of created profile
    WebElement signOut;
    @FindBy(id = "firstName")
    public//first name text field
    WebElement fNameProfileField;
    @FindBy(id = "middleName")//middle name text field
    WebElement mNameProfileField;
    @FindBy(id = "lastName")//last name text field
    WebElement lNameProfileField;
    @FindBy(id = "county")//country text field
    WebElement countryProfileField;
    @FindBy(id = "address")//address text field
    WebElement addressProfileField;
    @FindBy(id = "phone")//phone # text field
    WebElement phoneProfileField;
    @FindBy(id = "email")//email text field
    WebElement emailProfileField;

    public String actualFirst(){
        return fNameProfileField.getAttribute("value");
    }//get first name stored in profile
    public String actualMiddle(){
        return mNameProfileField.getAttribute("value");
    }//get middle name stored in profile
    public String actualLast(){
        return lNameProfileField.getAttribute("value");
    }//get last name stored in profile
    public String actualCountry(){
        return countryProfileField.getAttribute("value");
    }//get country stored in profile
    public String actualAddress(){
        return addressProfileField.getAttribute("value");
    }//get address stored in profile
    public String actualPhone(){
        return phoneProfileField.getAttribute("value");
    }//get phone # stored in profile
    public void gotoMyProfile(){
        try {
            profileIcon.click();
        } catch (StaleElementReferenceException e){
            profileIcon.click();
        }
        myProfile.click();
    }//go to my profile page
    public String actualEmail(){
        return emailProfileField.getAttribute("value");
    }//get email stored in profile
    public void logOut(){
        try {
            profileIcon.click();
        } catch (StaleElementReferenceException e){
            profileIcon.click();
        }
        signOut.click();
    }//go to my profile page
}

