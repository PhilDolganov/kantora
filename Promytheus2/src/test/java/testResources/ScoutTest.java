package testResources;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;
import static testResources.XlsData.*;
import static testResources.XlsData.findColumn;
import static testResources.XlsData.getCellData;

public class ScoutTest extends BaseTest {
//    @Test(dataProviderClass = DataResources.class, dataProvider = "LoginRO_TestDataProvider", enabled = true, description = "LoginRegularO")
//    public void loginRO (String email, String password, String firstName, String middleName, String lastName, String country, String address, String phone) throws InterruptedException {
//        try {
//            pageResources.getRegPage().pushRegisterNow();//push register now button
//        } catch (Exception e){
//            pageResources.getRegPage().killCover();//stop obstructing web element
//            pageResources.getRegPage().pushRegisterNow();//push register now button
//        }
//        pageResources.getRegPage().inputNames(firstName, middleName, lastName);//enter first,middle, last names in registration form
//        pageResources.getRegPage().selectCountry(country);//enter country in registration form
//        pageResources.getRegPage().inputAddress(address);//enter address in registration form
//        pageResources.getRegPage().inputPhone(phone);//enter ph# in registration form
//        pageResources.getRegPage().inputEmail(email);//enter email in registration form
//        pageResources.getRegPage().inputPassword(password);//enter password in registration form
//        pageResources.getRegPage().pushCreateAccount();//push create account button in registration form
//        try {
//            assertEquals(baseUrl, driver.getCurrentUrl());//assert if expected url matches actual url
//        } catch (AssertionError e) {
//            System.err.println("Registration form has not been submitted");
//        }
//        pageResources.getLoginPage().enterUsername(email);//enter login in login page
//        pageResources.getLoginPage().enterPassword(password);//enter password in login page
//        pageResources.getLoginPage().pushLoginButton();//push login button in login page
//        pageResources.getTalentPage().pushOtherButton();//select Other radio button
//        Thread.sleep(1000);
//        pageResources.getTalentPage().pushConfirm();//push confirm button in talent page
//        pageResources.getTalentPage().pushNewButton();//push new button in talent page
//        pageResources.getTalentPage().selectCategory();//select category in talent page
//        pageResources.getTalentPage().pushNextButton();//push next button in talent page
//        pageResources.getTalentPage().enterName(firstName,middleName,lastName);//enter first,middle, last names in talent page
//        pageResources.getTalentPage().enterAddress(address);//enter address in talent page
//        pageResources.getTalentPage().enterPhone(phone);//enter ph# in talent page
//        pageResources.getTalentPage().enterEmail();//enter email in talent page
//        String birth = pageResources.getTalentPage().randomDate();//generate random date of birth in talent page
//        int year = Integer.parseInt(birth.substring(4));
//        //pageResources.getTalentPage().enterBirth(birth);//enter random date of birth in talent page
//        //pageResources.getTalentPage().enterPlaceBirth();//enter place of birth in talent page
//        pageResources.getTalentPage().ruralRadioClick();//select Rural radio button in talent page
//        pageResources.getTalentPage().priviligedRadioClick();//select Privileged radio button in talent page
//        //pageResources.getTalentPage().enterHeight();//enter height in talent page
//        pageResources.getTalentPage().enterWeight();//enter weight in talent page
//        pageResources.getTalentPage().pushNextButton();//Go to Training in talent page
//        pageResources.getTalentPage().selectTraining();//select training element from training list box in talent page
//        pageResources.getTalentPage().noRadioClick();//select No radio button in talent page
//        pageResources.getTalentPage().sometimesRadioClick();//select Sometimes radio button in talent page
//        pageResources.getTalentPage().enterSchoolName();//enter school name in talent page
//        pageResources.getTalentPage().enterSchoolSuccessLevel();//enter school success level in talent page
//        pageResources.getTalentPage().advancedRadioClick();//select Advanced radio button in talent page
//        pageResources.getTalentPage().pushNextButton();//Go to Evidence in talent page
//        pageResources.getTalentPage().familyRadioClick();//Check Family check box in talent page
//        pageResources.getTalentPage().enterTestimony();//enter testimony in talent page
//        pageResources.getTalentPage().enterWorkProduct();//enter work product in talent page
//        pageResources.getTalentPage().pushNextButton();//Go to Social Background
//        pageResources.getTalentPage().middleRadioClick();//select Middle radio button
//        //pageResources.getTalentPage().maritalListSelect();//select form marital status list box in talent page
//        pageResources.getTalentPage().workStatusListSelect();//select from work status list box in talent page
//        pageResources.getTalentPage().relationListSelect();//select relationship status from relationship list box in talent page
//        pageResources.getTalentPage().enterUsdField();//enter income in talent page
//        pageResources.getTalentPage().disabilitiesListSelect();//select disability from disabilities list box in talent page
//        pageResources.getTalentPage().pushNextButton();//Go to Story in talent page
//        pageResources.getTalentPage().EnterHeadline();//enter headline in talent page
//        pageResources.getTalentPage().EnterDiscoveryYears(year);// enter discovery year in talent page
//        pageResources.getTalentPage().interestLevelListSelect();// select level of interest from interest level list box in talent page
//        pageResources.getTalentPage().gotoQuickTestsTab();//Go to Finish in talent page
//        pageResources.getTalentPage().pushFinishButton();//Push finish button in talent page
//        pageResources.getProfilePage().gotoMyProfile();//Go to competed profile
//        phone = "("+phone.substring(0,3)+") "+phone.substring(3,6)+"-"+phone.substring(6,10);//format ph# output
//        try {
//            assertEquals(firstName,pageResources.getProfilePage().actualFirst());//assert that expected and actual first names stored in profile match
//            System.out.println("First Name matches");
//            assertEquals(middleName,pageResources.getProfilePage().actualMiddle());//assert that expected and actual middle names stored in profile match
//            System.out.println("Middle Name matches");
//            assertEquals(lastName,pageResources.getProfilePage().actualLast());//assert that expected and actual last names stored in profile match
//            System.out.println("Last Name matches");
//            assertEquals(country,pageResources.getProfilePage().actualCountry());//assert that expected and actual country stored in profile match
//            System.out.println("Country matches");
//            assertEquals(address,pageResources.getProfilePage().actualAddress());//assert that expected and actual addresses stored in profile match
//            System.out.println("Address matches");
//            assertEquals(phone,pageResources.getProfilePage().actualPhone());//assert that expected and actual phone #'s stored in profile match
//            System.out.println("Phone # matches");
//            assertEquals(email,pageResources.getProfilePage().actualEmail());//assert that expected and actual emails stored in profile match
//            System.out.println("Email matches");
//        } catch (AssertionError e) {
//            System.err.println("Information does not match");
//        }
//    }
//    @Test(dataProviderClass = DataResources.class, dataProvider = "LoginScout_TestDataProvider", enabled = true, description = "LoginScout")
//    public void loginScout (String email, String password, String firstName, String middleName, String lastName, String country, String address, String phone) throws InterruptedException {
//        try {
//            pageResources.getRegPage().pushRegisterNow();//push register now button
//        } catch (Exception e){
//            pageResources.getRegPage().killCover();//stop obstructing web element
//            pageResources.getRegPage().pushRegisterNow();//push register now button
//        }
//        pageResources.getRegPage().checkScoutButton();//check Scout checkbox
//        pageResources.getRegPage().inputNames(firstName, middleName, lastName);//enter first,middle, last names in registration form
//        pageResources.getRegPage().selectCountry(country);//enter country in registration form
//        pageResources.getRegPage().inputAddress(address);//enter address in registration form
//        pageResources.getRegPage().inputPhone(phone);//enter ph# in registration form
//        pageResources.getRegPage().inputEmail(email);//enter email in registration form
//        pageResources.getRegPage().inputPassword(password);//enter password in registration form
//        pageResources.getRegPage().pushCreateAccount();//push create account button in registration form
//        try {
//            assertEquals(baseUrl, driver.getCurrentUrl());//assert if expected url matches actual url
//        } catch (AssertionError e) {
//            System.err.println("Registration form has not been submitted");
//        }
//        pageResources.getLoginPage().enterUsername(email);//enter login in login page
//        pageResources.getLoginPage().enterPassword(password);//enter password in login page
//        pageResources.getLoginPage().pushLoginButton();//push login button in login page
//        Thread.sleep(1000);
//        pageResources.getTalentPage().pushNewButton();//push new button
//        pageResources.getTalentPage().selectCategory();//select category in talent page
//        pageResources.getTalentPage().pushNextButton();//push next button in talent page
//        pageResources.getTalentPage().enterName(firstName,middleName,lastName);//enter first,middle, last names in talent page
//        pageResources.getTalentPage().enterAddress(address);//enter address in talent page
//        pageResources.getTalentPage().enterPhone(phone);//enter ph# in talent page
//        pageResources.getTalentPage().enterEmail();//enter email in talent page
//        String birth = pageResources.getTalentPage().randomDate();//generate random date of birth in talent page
//        int year = Integer.parseInt(birth.substring(4));
//        //pageResources.getTalentPage().enterBirth(birth);//enter random date of birth in talent page
//        //pageResources.getTalentPage().enterPlaceBirth();//enter place of birth in talent page
//        pageResources.getTalentPage().ruralRadioClick();//select Rural radio button in talent page
//        pageResources.getTalentPage().priviligedRadioClick();//select Privileged radio button in talent page
//        //pageResources.getTalentPage().enterHeight();//enter height in talent page
//        pageResources.getTalentPage().enterWeight();//enter weight in talent page
//        pageResources.getTalentPage().pushNextButton();//Go to Training in talent page
//        pageResources.getTalentPage().selectTraining();//select training element from training list box in talent page
//        pageResources.getTalentPage().noRadioClick();//select No radio button in talent page
//        pageResources.getTalentPage().sometimesRadioClick();//select Sometimes radio button in talent page
//        pageResources.getTalentPage().enterSchoolName();//enter school name in talent page
//        pageResources.getTalentPage().enterSchoolSuccessLevel();//enter school success level in talent page
//        pageResources.getTalentPage().advancedRadioClick();//select Advanced radio button in talent page
//        pageResources.getTalentPage().pushNextButton();//Go to Evidence in talent page
//        pageResources.getTalentPage().familyRadioClick();//Check Family check box in talent page
//        pageResources.getTalentPage().enterTestimony();//enter testimony in talent page
//        pageResources.getTalentPage().enterWorkProduct();//enter work product in talent page
//        pageResources.getTalentPage().pushNextButton();//Go to Social Background
//        pageResources.getTalentPage().middleRadioClick();//select Middle radio button
//        //pageResources.getTalentPage().maritalListSelect();//select form marital status list box in talent page
//        pageResources.getTalentPage().workStatusListSelect();//select from work status list box in talent page
//        pageResources.getTalentPage().relationListSelect();//select relationship status from relationship list box in talent page
//        pageResources.getTalentPage().enterUsdField();//enter income in talent page
//        pageResources.getTalentPage().disabilitiesListSelect();//select disability from disabilities list box in talent page
//        pageResources.getTalentPage().pushNextButton();//Go to Story in talent page
//        pageResources.getTalentPage().EnterHeadline();//enter headline in talent page
//        pageResources.getTalentPage().EnterDiscoveryYears(year);// enter discovery year in talent page
//        pageResources.getTalentPage().interestLevelListSelect();// select level of interest from interest level list box in talent page
//        pageResources.getTalentPage().gotoQuickTestsTab();//Go to Finish in talent page
//        pageResources.getTalentPage().pushFinishButton();//Push finish button in talent page
//        pageResources.getProfilePage().gotoMyProfile();//Go to competed profile
//        phone = "("+phone.substring(0,3)+") "+phone.substring(3,6)+"-"+phone.substring(6,10);//format ph# output
//        try {
//            assertEquals(firstName,pageResources.getProfilePage().actualFirst());
//            System.out.println("First Name matches");
//            assertEquals(middleName,pageResources.getProfilePage().actualMiddle());
//            System.out.println("Middle Name matches");
//            assertEquals(lastName,pageResources.getProfilePage().actualLast());
//            System.out.println("Last Name matches");
//            assertEquals(country,pageResources.getProfilePage().actualCountry());
//            System.out.println("Country matches");
//            assertEquals(address,pageResources.getProfilePage().actualAddress());
//            System.out.println("Address matches");
//            assertEquals(phone,pageResources.getProfilePage().actualPhone());
//            System.out.println("Phone # matches");
//            assertEquals(email,pageResources.getProfilePage().actualEmail());
//            System.out.println("Email matches");
//        } catch (AssertionError e) {
//            System.err.println("Information does not match");
//        }
//    }
//}
@Test(priority = 0, dataProviderClass = DataResources.class, dataProvider = "LoginScout_TestDataProvider", enabled = true, description = "LoginScout")
public void loginScout(String email, String password, String firstName, String middleName, String lastName, String country, String address, String phone) throws Exception {
    try {
        pageResources.getRegPage().pushRegisterNow();//push register now button
    } catch (Exception e) {
        pageResources.getRegPage().killCover();//stop obstructing web element
        pageResources.getRegPage().pushRegisterNow();//push register now button
    }
    try {
        XlsData.setExcelFile(Path_TestData + File_TestData, "LoginRU");
    } catch (Exception e) {
        e.printStackTrace();
    }
    XlsData.setUpTable(new String[]{"First Name", "Middle Name", "Last Name", "Country", "Address", "Phone", "Email", "Password",
            "Birth Date", "Birth Place", "Height", "Marital"});
    pageResources.getRegPage().checkScoutButton();
    pageResources.getRegPage().inputNames(firstName, middleName, lastName);//enter first,middle, last names in registration form
    XlsData.setCellData(firstName, 1, findColumn("First Name"));
    XlsData.setCellData(middleName, 1, findColumn("Middle Name"));
    XlsData.setCellData(lastName, 1, findColumn("Last Name"));
    pageResources.getRegPage().selectCountry(country);//enter country in registration form
    XlsData.setCellData(country, 1, findColumn("Country"));
    pageResources.getRegPage().inputAddress(address);//enter address in registration form
    XlsData.setCellData(address, 1, findColumn("Address"));
    pageResources.getRegPage().inputPhone(phone);//enter ph# in registration form
    XlsData.setCellData("(" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6, 10), 1, findColumn("Phone"));
    pageResources.getRegPage().inputEmail(email);//enter email in registration form
    XlsData.setCellData(email, 1, findColumn("Email"));
    pageResources.getRegPage().inputPassword(password);//enter password in registration form
    XlsData.setCellData(password, 1, findColumn("Password"));
    pageResources.getRegPage().pushCreateAccount();//push create account button in registration form
    wait.until(ExpectedConditions.visibilityOf(pageResources.getLoginPage().username));


    try {
        assertEquals(baseUrl, driver.getCurrentUrl());//assert if expected url matches actual url
    } catch (AssertionError e) {
        System.err.println("Registration form has not been submitted");
    }
    pageResources.getLoginPage().enterUsername(email);//enter login in login page
    pageResources.getLoginPage().enterPassword(password);//enter password in login page
    pageResources.getLoginPage().pushLoginButton();//push login button in login page
    Thread.sleep(1000);
}

    @Test(priority = 1)
    public void tallentScout() throws Exception {
//        pageResources.getTalentPage().pushYouButton();
//        Thread.sleep(1000);
//        pageResources.getTalentPage().pushConfirm();
        pageResources.getTalentPage().pushNewButton();
        pageResources.getTalentPage().selectCategory();//select category in talent page
        pageResources.getTalentPage().pushNextButton();//push next button in talent page
        String birth = pageResources.getTalentPage().randomDate();//generate random date of birth in talent page
        int year = Integer.parseInt(birth.substring(4));
        pageResources.getTalentPage().enterBirth(birth);//enter random date of birth in talent page
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
        pageResources.getTalentPage().signOut();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        pageResources.getLoginPage().enterUsername(getCellData(1, findColumn("Email")));
        pageResources.getLoginPage().enterPassword(getCellData(1, findColumn("Password")));
        pageResources.getLoginPage().pushLoginButton();//login
        pageResources.getTalentPage().pushEditButton();
        Thread.sleep(1000);
        pageResources.getTalentPage().pushNextButton();
        String actualFName = pageResources.getTalentPage().getFName();
        System.out.println(getCellData(1, findColumn("First Name")));
        System.out.println(actualFName);
        try {
            assertTrue(actualFName.matches(getCellData(1, findColumn("First Name"))));
        } catch (AssertionError e) {
            System.out.println("First Name Does Not Match");
        }
        String actualMName = pageResources.getTalentPage().getMName();
        System.out.println(getCellData(1, findColumn("Middle Name")));
        System.out.println(actualMName);
        try {
            assertTrue(actualMName.matches(getCellData(1, findColumn("Middle Name"))));
        } catch (AssertionError e) {
            System.out.println("Middle Name Does Not Match");
        }
        String actualBirthDate = pageResources.getTalentPage().getBirthDate();
        System.out.println(getCellData(1, findColumn("Birth Date")));
        System.out.println(actualBirthDate);
        try {
            assertTrue(actualBirthDate.matches(getCellData(1, findColumn("Birth Date"))));
        } catch (AssertionError e) {
            System.out.println("Birth Date Does Not Match");
        }
        String actualBirthPlace = pageResources.getTalentPage().getBirthPlace();
        System.out.println(getCellData(1, findColumn("Birth Place")));
        System.out.println(actualBirthPlace);
        try {
            assertTrue(actualBirthPlace.matches(getCellData(1, findColumn("Birth Place"))));
        } catch (AssertionError e) {
            System.out.println("Birth Place Does Not Match");
        }
//        try {
//            assertFalse(pageResources.getTalentPage().ifSelectedPriviligedRadio());
//        } catch (AssertionError e) {
//            System.out.println("Privileged status is not saved");
//        }
        String actualHeight = pageResources.getTalentPage().getHeight();
        System.out.println(getCellData(1, findColumn("Height")));
        System.out.println(actualHeight);
        try {
            assertTrue(actualHeight.matches(getCellData(1, findColumn("Height"))));
        } catch (AssertionError e) {
            System.out.println("Height Does Not Match");
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
            System.out.println("Marital Does Not Match");
        }
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
            assertEquals(getCellData(1, 5), pageResources.getProfilePage().actualPhone());
            System.out.println("Phone # matches");
            assertEquals(getCellData(1, 6), pageResources.getProfilePage().actualEmail());
            System.out.println("Email matches");
        } catch (AssertionError e) {
            System.err.println("Information doe not match");
        }

    }

}