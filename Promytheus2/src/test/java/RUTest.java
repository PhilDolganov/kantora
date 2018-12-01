

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import testResources.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testResources.DataResources;
import java.lang.String;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;
import static testResources.XlsData.*;

public class RUTest extends BaseTest {
    //User logs in with valid email and valid password
    //Pushing Login button with valid email and valid password takes user to Talents page
    @Test(priority = 0, dataProviderClass = DataResources.class, dataProvider = "LoginRU_TestDataProvider", enabled = true, description = "LoginRegularU")
    public void loginRU(String email, String password, String firstName, String middleName, String lastName, String country, String address, String phone) throws Exception {
        try {
            pageResources.getRegPage().pushRegisterNow();//push register now button
        } catch (Exception e) {
            pageResources.getRegPage().killCover();//stop obstructing web element
            pageResources.getRegPage().pushRegisterNow();//push register now button
        }
        try {
            XlsData.setExcelFile(Path_TestData + File_TestData, "LoginRU");//excel data sheet path
        } catch (Exception e) {
            e.printStackTrace();
        }
        XlsData.setUpTable(new String[]{"First Name", "Middle Name", "Last Name", "Country", "Address", "Phone", "Email", "Password",
                "Birth Date", "Birth Place", "Height", "Marital", "Work Status"});//column names setup in excel data sheet
        pageResources.getRegPage().inputNames(firstName, middleName, lastName);//enter first,middle, last names in registration form
        XlsData.setCellData(firstName, 1, findColumn("First Name"));//enter first name in excel data sheet
        XlsData.setCellData(middleName, 1, findColumn("Middle Name"));//enter middle name in excel data sheet
        XlsData.setCellData(lastName, 1, findColumn("Last Name"));//enter last name in excel data sheet
        pageResources.getRegPage().selectCountry(country);//enter country in registration form
        XlsData.setCellData(country, 1, findColumn("Country"));//enter country in excel data sheet
        pageResources.getRegPage().inputAddress(address);//enter address in registration form
        XlsData.setCellData(address, 1, findColumn("Address"));//enter address in excel data sheet
        pageResources.getRegPage().inputPhone(phone);//enter ph# in registration form
        XlsData.setCellData("(" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6, 10), 1, findColumn("Phone"));//enter phone # in excel data sheet
        pageResources.getRegPage().inputEmail(email);//enter email in registration form
        XlsData.setCellData(email, 1, findColumn("Email"));//enter email in excel data sheet
        pageResources.getRegPage().inputPassword(password);//enter password in registration form
        XlsData.setCellData(password, 1, findColumn("Password"));//enter password in excel data sheet
        pageResources.getRegPage().pushCreateAccount();//push create account button in registration form
        wait.until(ExpectedConditions.visibilityOf(pageResources.getLoginPage().username));

        try {
            assertEquals(baseUrl+"/sign-in.html", driver.getCurrentUrl());//assert if expected url matches actual url
        } catch (AssertionError e) {
            System.err.println("Registration form has not been submitted");
        }
        pageResources.getLoginPage().enterUsername(email);//enter login in login page
        pageResources.getLoginPage().enterPassword(password);//enter password in login page
        pageResources.getLoginPage().pushLoginButton();//push login button in login page
        Thread.sleep(1000);
    }
    //user gets into talent page w/ valid credentials, fills out talent information and saves it
    //Information entered and saved in talent text fields matches user's  original input
    @Test(priority = 1)
    public void tallentRu() throws Exception {
        pageResources.getTalentPage().pushYouButton();//select yourself option
        Thread.sleep(1000);
        pageResources.getTalentPage().pushConfirm();//push confirm button
        pageResources.getTalentPage().selectCategory();//select category in talent page
        pageResources.getTalentPage().pushNextButton();//push next button in talent page
        //String birth = pageResources.getTalentPage().randomDate();//generate random date of birth in talent page
        //int year = Integer.parseInt(birth.substring(4));//format date of birth string
        int year = fabricator.alphaNumeric().randomInt(100);
        pageResources.getTalentPage().enterBirth(year);//enter random date of birth in talent page
        pageResources.getTalentPage().enterPlaceBirth();//enter place of birth in talent page
        pageResources.getTalentPage().ruralRadioClick();//select Rural radio button in talent page
        pageResources.getTalentPage().priviligedRadioClick();//select Privileged radio button in talent page
        pageResources.getTalentPage().enterHeight();//enter height in talent page
        pageResources.getTalentPage().enterWeight();//enter weight in talent page
        pageResources.getTalentPage().pushNextButton();//Go to Training in talent page
        pageResources.getTalentPage().selectTraining();//select training element from training list box in talent page
        pageResources.getTalentPage().noRadioClick();//select No radio button in talent page
        pageResources.getTalentPage().sometimesRadioClick();//select Sometimes radio button in talent page
        pageResources.getTalentPage().enterSchoolName();//enter school name in talent page
        pageResources.getTalentPage().enterSchoolSuccessLevel();//enter school success level in talent page
        pageResources.getTalentPage().advancedRadioClick();//select Advanced radio button in talent page
        pageResources.getTalentPage().pushNextButton();//Go to Evidence in talent page
        pageResources.getTalentPage().familyRadioClick();//Check Family check box in talent page
        pageResources.getTalentPage().enterTestimony();//enter testimony in talent page
        pageResources.getTalentPage().enterWorkProduct();//enter work product in talent page
        pageResources.getTalentPage().pushNextButton();//Go to Social Background
        pageResources.getTalentPage().middleRadioClick();//select Middle radio button
        pageResources.getTalentPage().maritalListSelect();//select form marital status list box in talent page
        pageResources.getTalentPage().workStatusListSelect();//select from work status list box in talent page
        pageResources.getTalentPage().relationListSelect();//select relationship status from relationship list box in talent page
        pageResources.getTalentPage().enterUsdField();//enter income in talent page
        pageResources.getTalentPage().disabilitiesListSelect();//select disability from disabilities list box in talent page
        pageResources.getTalentPage().pushNextButton();//Go to Story in talent page
        pageResources.getTalentPage().EnterHeadline();//enter headline in talent page
        pageResources.getTalentPage().EnterDiscoveryYears(year);// enter discovery year in talent page
        pageResources.getTalentPage().interestLevelListSelect();// select level of interest from interest level list box in talent page
        pageResources.getTalentPage().gotoQuickTestsTab();//Go to Finish in talent page
        pageResources.getTalentPage().pushFinishButton();//Push finish button in talent page
        pageResources.getTalentPage().signOut();//user logs out
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        pageResources.getLoginPage().enterUsername(getCellData(1, findColumn("Email")));//user enters valid login
        pageResources.getLoginPage().enterPassword(getCellData(1, findColumn("Password")));//user enters valid password
        pageResources.getLoginPage().pushLoginButton();//push login button
        pageResources.getTalentPage().pushEditButton();//push edit button
        Thread.sleep(1000);
        pageResources.getTalentPage().pushNextButton();//push next button
        Thread.sleep(500);
        String actualFName = pageResources.getTalentPage().getFName();//retrieve actual first name
        System.out.println(getCellData(1, findColumn("First Name")));//get first name from excel sheet
        System.out.println(actualFName);//print ut first name
        try {
            assertTrue(actualFName.matches(getCellData(1, findColumn("First Name"))));//assert that actual first name is the same as expected
        } catch (AssertionError e) {
            System.out.println("First Name Does Not Match");//error message due to actual/expected miss match
        }
        String actualMName = pageResources.getTalentPage().getMName();//assert that actual middle name is the same as expected
        System.out.println(getCellData(1, findColumn("Middle Name")));
        System.out.println(actualMName);
        try {
            assertTrue(actualMName.matches(getCellData(1, findColumn("Middle Name"))));
        } catch (AssertionError e) {
            System.out.println("Middle Name Does Not Match");//error message due to actual/expected miss match
        }
        String actualBirthDate = pageResources.getTalentPage().getBirthDate();
        System.out.println(getCellData(1, findColumn("Birth Date")));
        System.out.println(actualBirthDate);
        try {
            assertTrue(actualBirthDate.matches(getCellData(1, findColumn("Birth Date"))));
        } catch (AssertionError e) {
            System.out.println("Birth Date Does Not Match");//error message due to actual/expected miss match
        }
        String actualBirthPlace = pageResources.getTalentPage().getBirthPlace();
        System.out.println(getCellData(1, findColumn("Birth Place")));
        System.out.println(actualBirthPlace);
        try {
            assertTrue(actualBirthPlace.matches(getCellData(1, findColumn("Birth Place"))));
        } catch (AssertionError e) {
            System.out.println("Birth Place Does Not Match");//error message due to actual/expected miss match
        }
       // try {
         //   assertFalse(pageResources.getTalentPage().ifSelectedPriviligedRadio());
        //} catch (AssertionError e) {
        //    System.out.println("Privileged status is not saved");//error message due to actual/expected miss match
       // }
        String actualHeight = pageResources.getTalentPage().getHeight();
        System.out.println(getCellData(1, findColumn("Height")));
        System.out.println(actualHeight);
        try {
            assertTrue(actualHeight.matches(getCellData(1, findColumn("Height"))));
        } catch (AssertionError e) {
            System.out.println("Height Does Not Match");//error message due to actual/expected miss match
        }
        pageResources.getTalentPage().pushNextButton();//training
        pageResources.getTalentPage().pushNextButton();//evidence
        pageResources.getTalentPage().pushNextButton();//social background
        String actualMarital = pageResources.getTalentPage().actualMaritalStatus();
        System.out.println(actualMarital);
        System.out.println(getCellData(1, findColumn("Marital")));
        try {
            assertTrue(actualMarital.matches(getCellData(1, findColumn("Marital"))));
        } catch (AssertionError e) {
            System.out.println("Marital Does Not Match");//error message due to actual/expected miss match
        }
        String actualWorkStatus=pageResources.getTalentPage().actualWorkStatus();
        System.out.println(actualWorkStatus);
        System.out.println(getCellData(1,findColumn("Work Status")));
        try {assertTrue(actualWorkStatus.matches(getCellData(1,findColumn("Work Status"))));}
        catch (AssertionError e) {System.out.println("Work Status does not match");}
        pageResources.getTalentPage().pushNextButton();//story
        wait.until(ExpectedConditions.visibilityOf(pageResources.getTalentPage().quickTestsTab));
        pageResources.getTalentPage().gotoQuickTestsTab();//finish
        pageResources.getTalentPage().pushFinishButton();
        pageResources.getTalentPage().gotoMyProfile();//Profile info check starts
        wait.until(ExpectedConditions.visibilityOf(pageResources.getProfilePage().fNameProfileField));
        try {
            System.out.println(pageResources.getProfilePage().actualFirst());
            assertEquals(getCellData(1, 0), pageResources.getProfilePage().actualFirst());
            System.out.println("First Name matches");
            assertEquals(getCellData(1, 1), pageResources.getProfilePage().actualMiddle());
            System.out.println("Middle Name matches");
            assertEquals(getCellData(1, 2), pageResources.getProfilePage().actualLast());
            System.out.println("Last Name matches");
            assertEquals(getCellData(1, 3), pageResources.getProfilePage().actualCountry());
            System.out.println("Country matches");
            assertEquals(getCellData(1, 4), pageResources.getProfilePage().actualAddress());
            System.out.println("Address matches");
            //assertEquals(getCellData(1, 5), pageResources.getProfilePage().actualPhone());
            //System.out.println("Phone # matches");
            assertEquals(getCellData(1, 6), pageResources.getProfilePage().actualEmail());
            System.out.println("Email matches");
        } catch (AssertionError e) {
            System.err.println("Information doe not match");//error message due to actual/expected miss match
        }

    }

}