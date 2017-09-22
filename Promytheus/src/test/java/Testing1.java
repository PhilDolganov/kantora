
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegPage;
import testResources.DataResources;
import testResources.PageResources;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Testing1 {
    private WebDriver driver;
    private String baseUrl;
    WebDriverWait wait;
    String talentUrl = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/talent.html";
    PageResources pageResources;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        pageResources = new PageResources(driver);
        wait = new WebDriverWait(driver, 5);
        baseUrl = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test(dataProviderClass = DataResources.class, dataProvider = "Negative_TestDataProvider", enabled = true, description = "Negative")
    public void LoginNegative(String email, String password, String email1, String password1, String errorMessage) {
        String firstName = RandomStringUtils.randomAlphabetic(5);
        String middleName = RandomStringUtils.randomAlphabetic(5);
        String lastName = RandomStringUtils.randomAlphabetic(5);
        String country = RandomStringUtils.randomAlphabetic(5, 7);
        String address = RandomStringUtils.randomNumeric(4) + " " + RandomStringUtils.randomAlphabetic(5);
        String phone = RandomStringUtils.randomNumeric(10);

        try {
            pageResources.getRegPage().pushRegisterNow();
        } catch (Exception e) {
            pageResources.getRegPage().killCover();
            pageResources.getRegPage().pushRegisterNow();
        }
        pageResources.getRegPage().inputNames(firstName,middleName,lastName);
        pageResources.getRegPage().selectCountry(country);
        pageResources.getRegPage().inputAddress(address);
        pageResources.getRegPage().inputPhone(phone);
        pageResources.getRegPage().inputEmail(email);
        pageResources.getRegPage().inputPassword(password);
        pageResources.getRegPage().pushCreateAccount();
        pageResources.getLoginPage().enterUsername(email1);
        pageResources.getLoginPage().enterPassword(password1);
        pageResources.getLoginPage().pushLoginButton();

        try {
            assertEquals(baseUrl,driver.getCurrentUrl());
        } catch (AssertionError e){
            System.err.println(errorMessage);
        }
    }
    @Test(dataProviderClass = DataResources.class, dataProvider = "LoginRU_TestDataProvider", enabled = true, description = "LoginRegularU")
    public void loginRU (String email, String password, String firstName, String middleName, String lastName, String country, String address, String phone) throws InterruptedException {
        try {
            pageResources.getRegPage().pushRegisterNow();
        } catch (Exception e){
            pageResources.getRegPage().killCover();
            pageResources.getRegPage().pushRegisterNow();
        }
        pageResources.getRegPage().inputNames(firstName, middleName, lastName);
        pageResources.getRegPage().selectCountry(country);
        pageResources.getRegPage().inputAddress(address);
        pageResources.getRegPage().inputPhone(phone);
        pageResources.getRegPage().inputEmail(email);
        pageResources.getRegPage().inputPassword(password);
        pageResources.getRegPage().pushCreateAccount();
        try {
            assertEquals(baseUrl, driver.getCurrentUrl());
        } catch (AssertionError e) {
            System.err.println("Registration form has not been submitted");
        }
        pageResources.getLoginPage().enterUsername(email);
        pageResources.getLoginPage().enterPassword(password);
        pageResources.getLoginPage().pushLoginButton();
        pageResources.getTalentPage().pushYouButton();
        Thread.sleep(1000);
        pageResources.getTalentPage().pushConfirm();
        pageResources.getTalentPage().selectCategory();
        pageResources.getTalentPage().pushNextButton();
        String birth = pageResources.getTalentPage().randomDate();
        int year = Integer.parseInt(birth.substring(4));
        pageResources.getTalentPage().enterBirth(birth);
        pageResources.getTalentPage().enterPlaceBirth();
        pageResources.getTalentPage().ruralRadioClick();
        pageResources.getTalentPage().privelegedRadioClick();
        pageResources.getTalentPage().enterHeight();
        pageResources.getTalentPage().enterWeight();
        pageResources.getTalentPage().pushNextButton();//Training
        pageResources.getTalentPage().selectTraining();
        pageResources.getTalentPage().noRadioClick();
        pageResources.getTalentPage().sometimesRadioClick();
        pageResources.getTalentPage().enterSchoolName();
        pageResources.getTalentPage().enterSchoolSuccessLevel();
        pageResources.getTalentPage().advancedRadioClick();
        pageResources.getTalentPage().pushNextButton();//Evidence
        pageResources.getTalentPage().familyRadioClick();
        pageResources.getTalentPage().enterTestimony();
        pageResources.getTalentPage().enterWorkProduct();
        pageResources.getTalentPage().pushNextButton();//Social Background
        pageResources.getTalentPage().middleRadioClick();
        pageResources.getTalentPage().maritalListSelect();
        pageResources.getTalentPage().workStatusListSelect();
        pageResources.getTalentPage().relationListSelect();
        pageResources.getTalentPage().enterUsdField();
        pageResources.getTalentPage().disabilitiesListSelect();
        pageResources.getTalentPage().pushNextButton();//Story
        pageResources.getTalentPage().EnterHeadline();
        pageResources.getTalentPage().EnterDiscoveryYears(year);
        pageResources.getTalentPage().interestLevelListSelect();
        pageResources.getTalentPage().gotoQuickTestsTab();//Finish
        pageResources.getTalentPage().pushFinishButton();
        pageResources.getProfilePage().gotoMyProfile();
        phone = "("+phone.substring(0,3)+") "+phone.substring(3,6)+"-"+phone.substring(6,10);//format ph# output
        try {
            assertEquals(firstName,pageResources.getProfilePage().actualFirst());
            System.out.println("First Name matches");
            assertEquals(middleName,pageResources.getProfilePage().actualMiddle());
            System.out.println("Middle Name matches");
            assertEquals(lastName,pageResources.getProfilePage().actualLast());
            System.out.println("Last Name matches");
            assertEquals(country,pageResources.getProfilePage().actualCountry());
            System.out.println("Country matches");
            assertEquals(address,pageResources.getProfilePage().actualAddress());
            System.out.println("Address matches");
            assertEquals(phone,pageResources.getProfilePage().actualPhone());
            System.out.println("Phone # matches");
            assertEquals(email,pageResources.getProfilePage().actualEmail());
            System.out.println("Email matches");
        } catch (AssertionError e) {
            System.err.println("Information does not match");
        }
    }
    @Test(dataProviderClass = DataResources.class, dataProvider = "LoginRO_TestDataProvider", enabled = true, description = "LoginRegularO")
    public void loginRO (String email, String password, String firstName, String middleName, String lastName, String country, String address, String phone) throws InterruptedException {
        try {
            pageResources.getRegPage().pushRegisterNow();
        } catch (Exception e){
            pageResources.getRegPage().killCover();
            pageResources.getRegPage().pushRegisterNow();
        }
        pageResources.getRegPage().inputNames(firstName, middleName, lastName);
        pageResources.getRegPage().selectCountry(country);
        pageResources.getRegPage().inputAddress(address);
        pageResources.getRegPage().inputPhone(phone);
        pageResources.getRegPage().inputEmail(email);
        pageResources.getRegPage().inputPassword(password);
        pageResources.getRegPage().pushCreateAccount();
        try {
            assertEquals(baseUrl, driver.getCurrentUrl());
        } catch (AssertionError e) {
            System.err.println("Registration form has not been submitted");
        }
        pageResources.getLoginPage().enterUsername(email);
        pageResources.getLoginPage().enterPassword(password);
        pageResources.getLoginPage().pushLoginButton();
        pageResources.getTalentPage().pushOtherButton();
        Thread.sleep(1000);
        pageResources.getTalentPage().pushConfirm();
        pageResources.getTalentPage().pushNewButton();
        pageResources.getTalentPage().selectCategory();
        pageResources.getTalentPage().pushNextButton();
        pageResources.getTalentPage().enterName(firstName,middleName,lastName);
        pageResources.getTalentPage().enterAddress(address);
        pageResources.getTalentPage().enterPhone(phone);
        pageResources.getTalentPage().enterEmail();
        String birth = pageResources.getTalentPage().randomDate();
        int year = Integer.parseInt(birth.substring(4));
        pageResources.getTalentPage().enterBirth(birth);
        pageResources.getTalentPage().enterPlaceBirth();
        pageResources.getTalentPage().ruralRadioClick();
        pageResources.getTalentPage().privelegedRadioClick();
        pageResources.getTalentPage().enterHeight();
        pageResources.getTalentPage().enterWeight();
        pageResources.getTalentPage().pushNextButton();//Training
        pageResources.getTalentPage().selectTraining();
        pageResources.getTalentPage().noRadioClick();
        pageResources.getTalentPage().sometimesRadioClick();
        pageResources.getTalentPage().enterSchoolName();
        pageResources.getTalentPage().enterSchoolSuccessLevel();
        pageResources.getTalentPage().advancedRadioClick();
        pageResources.getTalentPage().pushNextButton();//Evidence
        pageResources.getTalentPage().familyRadioClick();
        pageResources.getTalentPage().enterTestimony();
        pageResources.getTalentPage().enterWorkProduct();
        pageResources.getTalentPage().pushNextButton();//Social Background
        pageResources.getTalentPage().middleRadioClick();
        pageResources.getTalentPage().maritalListSelect();
        pageResources.getTalentPage().workStatusListSelect();
        pageResources.getTalentPage().relationListSelect();
        pageResources.getTalentPage().enterUsdField();
        pageResources.getTalentPage().disabilitiesListSelect();
        pageResources.getTalentPage().pushNextButton();//Story
        pageResources.getTalentPage().EnterHeadline();
        pageResources.getTalentPage().EnterDiscoveryYears(year);
        pageResources.getTalentPage().interestLevelListSelect();
        pageResources.getTalentPage().gotoQuickTestsTab();//Finish
        pageResources.getTalentPage().pushFinishButton();
        pageResources.getProfilePage().gotoMyProfile();
        phone = "("+phone.substring(0,3)+") "+phone.substring(3,6)+"-"+phone.substring(6,10);//format ph# output
        try {
            assertEquals(firstName,pageResources.getProfilePage().actualFirst());
            System.out.println("First Name matches");
            assertEquals(middleName,pageResources.getProfilePage().actualMiddle());
            System.out.println("Middle Name matches");
            assertEquals(lastName,pageResources.getProfilePage().actualLast());
            System.out.println("Last Name matches");
            assertEquals(country,pageResources.getProfilePage().actualCountry());
            System.out.println("Country matches");
            assertEquals(address,pageResources.getProfilePage().actualAddress());
            System.out.println("Address matches");
            assertEquals(phone,pageResources.getProfilePage().actualPhone());
            System.out.println("Phone # matches");
            assertEquals(email,pageResources.getProfilePage().actualEmail());
            System.out.println("Email matches");
        } catch (AssertionError e) {
            System.err.println("Information does not match");
        }
    }
    @Test(dataProviderClass = DataResources.class, dataProvider = "LoginScout_TestDataProvider", enabled = true, description = "LoginScout")
    public void loginScout (String email, String password, String firstName, String middleName, String lastName, String country, String address, String phone) throws InterruptedException {
        try {
            pageResources.getRegPage().pushRegisterNow();
        } catch (Exception e){
            pageResources.getRegPage().killCover();
            pageResources.getRegPage().pushRegisterNow();
        }
        pageResources.getRegPage().checkScoutButton();
        pageResources.getRegPage().inputNames(firstName, middleName, lastName);
        pageResources.getRegPage().selectCountry(country);
        pageResources.getRegPage().inputAddress(address);
        pageResources.getRegPage().inputPhone(phone);
        pageResources.getRegPage().inputEmail(email);
        pageResources.getRegPage().inputPassword(password);
        pageResources.getRegPage().pushCreateAccount();
        try {
            assertEquals(baseUrl, driver.getCurrentUrl());
        } catch (AssertionError e) {
            System.err.println("Registration form has not been submitted");
        }
        pageResources.getLoginPage().enterUsername(email);
        pageResources.getLoginPage().enterPassword(password);
        pageResources.getLoginPage().pushLoginButton();
        Thread.sleep(1000);
        pageResources.getTalentPage().pushNewButton();
        pageResources.getTalentPage().selectCategory();
        pageResources.getTalentPage().pushNextButton();
        pageResources.getTalentPage().enterName(firstName,middleName,lastName);
        pageResources.getTalentPage().enterAddress(address);
        pageResources.getTalentPage().enterPhone(phone);
        pageResources.getTalentPage().enterEmail();
        String birth = pageResources.getTalentPage().randomDate();
        int year = Integer.parseInt(birth.substring(4));
        pageResources.getTalentPage().enterBirth(birth);
        pageResources.getTalentPage().enterPlaceBirth();
        pageResources.getTalentPage().ruralRadioClick();
        pageResources.getTalentPage().privelegedRadioClick();
        pageResources.getTalentPage().enterHeight();
        pageResources.getTalentPage().enterWeight();
        pageResources.getTalentPage().pushNextButton();//Training
        pageResources.getTalentPage().selectTraining();
        pageResources.getTalentPage().noRadioClick();
        pageResources.getTalentPage().sometimesRadioClick();
        pageResources.getTalentPage().enterSchoolName();
        pageResources.getTalentPage().enterSchoolSuccessLevel();
        pageResources.getTalentPage().advancedRadioClick();
        pageResources.getTalentPage().pushNextButton();//Evidence
        pageResources.getTalentPage().familyRadioClick();
        pageResources.getTalentPage().enterTestimony();
        pageResources.getTalentPage().enterWorkProduct();
        pageResources.getTalentPage().pushNextButton();//Social Background
        pageResources.getTalentPage().middleRadioClick();
        pageResources.getTalentPage().maritalListSelect();
        pageResources.getTalentPage().workStatusListSelect();
        pageResources.getTalentPage().relationListSelect();
        pageResources.getTalentPage().enterUsdField();
        pageResources.getTalentPage().disabilitiesListSelect();
        pageResources.getTalentPage().pushNextButton();//Story
        pageResources.getTalentPage().EnterHeadline();
        pageResources.getTalentPage().EnterDiscoveryYears(year);
        pageResources.getTalentPage().interestLevelListSelect();
        pageResources.getTalentPage().gotoQuickTestsTab();//Finish
        pageResources.getTalentPage().pushFinishButton();
        pageResources.getProfilePage().gotoMyProfile();
        phone = "("+phone.substring(0,3)+") "+phone.substring(3,6)+"-"+phone.substring(6,10);//format ph# output
        try {
            assertEquals(firstName,pageResources.getProfilePage().actualFirst());
            System.out.println("First Name matches");
            assertEquals(middleName,pageResources.getProfilePage().actualMiddle());
            System.out.println("Middle Name matches");
            assertEquals(lastName,pageResources.getProfilePage().actualLast());
            System.out.println("Last Name matches");
            assertEquals(country,pageResources.getProfilePage().actualCountry());
            System.out.println("Country matches");
            assertEquals(address,pageResources.getProfilePage().actualAddress());
            System.out.println("Address matches");
            assertEquals(phone,pageResources.getProfilePage().actualPhone());
            System.out.println("Phone # matches");
            assertEquals(email,pageResources.getProfilePage().actualEmail());
            System.out.println("Email matches");
        } catch (AssertionError e) {
            System.err.println("Information does not match");
        }
    }
    @AfterMethod
    public void tearDown () throws Exception {
        driver.close();
    }
    @AfterTest
    public void quit () throws Exception {
        driver.quit();
    }
}





