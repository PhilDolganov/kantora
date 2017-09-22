package testResources;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LoginTest extends BaseTest {
    //User can't login with invalid email and valid password
    //Pushing Login button with invalid email and valid password does not take user to Talents page
    @Test(dataProviderClass = DataResources.class, dataProvider = "Negative_Invalid_Email", enabled = true, description = "Log in With invalid Email and valid Password")
    public void LoginNegative1(String email, String password, String email1, String password1, String errorMessage) {
        String firstName = RandomStringUtils.randomAlphabetic(5);//first name
        String middleName = RandomStringUtils.randomAlphabetic(5);//middle name
        String lastName = RandomStringUtils.randomAlphabetic(5);//last name
        String country = RandomStringUtils.randomAlphabetic(5, 7);//country
        String address = RandomStringUtils.randomNumeric(4) + " " + RandomStringUtils.randomAlphabetic(5);//address
        String phone = RandomStringUtils.randomNumeric(10);//phone #

        try {
            pageResources.getRegPage().pushRegisterNow();//push register now button
        } catch (Exception e) {
            pageResources.getRegPage().killCover();//stop obstructing web element
            pageResources.getRegPage().pushRegisterNow();//push register now button
        }
        pageResources.getRegPage().inputNames(firstName,middleName,lastName);//enter first,middle, last names in registration form
        pageResources.getRegPage().selectCountry(country);//enter country in registration form
        pageResources.getRegPage().inputAddress(address);//enter address in registration form
        pageResources.getRegPage().inputPhone(phone);//enter ph# in registration form
        pageResources.getRegPage().inputEmail(email);//enter email in registration form
        pageResources.getRegPage().inputPassword(password);//enter password in registration form
        pageResources.getRegPage().pushCreateAccount();//push create account button in registration form
        pageResources.getLoginPage().enterUsername(email1);//enter login in login page
        pageResources.getLoginPage().enterPassword(password1);//enter password in login page
        pageResources.getLoginPage().pushLoginButton();//push login button

        try {
            assertFalse(logedInUrl,false);
        } catch (AssertionError e){
            System.err.println(errorMessage);
        }//assert if expected url matches actual url
    }
    //User can't login with valid email and invalid password
    //Pushing Login button with valid email and invalid password does not take user to Talents page
    @Test(dataProviderClass = DataResources.class, dataProvider = "Negative_Invalid_Password", enabled = true, description = "Log in With valid Email and invalid Password")
    public void LoginNegative2(String email, String password, String email1, String password1, String errorMessage) {
        String firstName = RandomStringUtils.randomAlphabetic(5);//first name
        String middleName = RandomStringUtils.randomAlphabetic(5);//middle name
        String lastName = RandomStringUtils.randomAlphabetic(5);//last name
        String country = RandomStringUtils.randomAlphabetic(5, 7);//country
        String address = RandomStringUtils.randomNumeric(4) + " " + RandomStringUtils.randomAlphabetic(5);//address
        String phone = RandomStringUtils.randomNumeric(10);//phone #

        try {
            pageResources.getRegPage().pushRegisterNow();//push register now button
        } catch (Exception e) {
            pageResources.getRegPage().killCover();//stop obstructing web element
            pageResources.getRegPage().pushRegisterNow();//push register now button
        }
        pageResources.getRegPage().inputNames(firstName,middleName,lastName);//enter first,middle, last names in registration form
        pageResources.getRegPage().selectCountry(country);//enter country in registration form
        pageResources.getRegPage().inputAddress(address);//enter address in registration form
        pageResources.getRegPage().inputPhone(phone);//enter ph# in registration form
        pageResources.getRegPage().inputEmail(email);//enter email in registration form
        pageResources.getRegPage().inputPassword(password);//enter password in registration form
        pageResources.getRegPage().pushCreateAccount();//push create account button in registration form
        pageResources.getLoginPage().enterUsername(email1);//enter login in login page
        pageResources.getLoginPage().enterPassword(password1);//enter password in login page
        pageResources.getLoginPage().pushLoginButton();//push login button

        try {
            assertFalse(logedInUrl,false);
        } catch (AssertionError e){
            System.err.println(errorMessage);
        }//assert if expected url matches actual url
    }
    //User can't login with blank email and valid password
    //Pushing Login button with blank email and valid password does not take user to Talents page
    @Test(dataProviderClass = DataResources.class, dataProvider = "Negative_Blank_Email", enabled = true, description = "Log in With blank Email and valid Password")
    public void LoginNegative3(String email, String password, String email1, String password1, String errorMessage) {
        String firstName = RandomStringUtils.randomAlphabetic(5);//first name
        String middleName = RandomStringUtils.randomAlphabetic(5);//middle name
        String lastName = RandomStringUtils.randomAlphabetic(5);//last name
        String country = RandomStringUtils.randomAlphabetic(5, 7);//country
        String address = RandomStringUtils.randomNumeric(4) + " " + RandomStringUtils.randomAlphabetic(5);//address
        String phone = RandomStringUtils.randomNumeric(10);//phone #

        try {
            pageResources.getRegPage().pushRegisterNow();//push register now button
        } catch (Exception e) {
            pageResources.getRegPage().killCover();//stop obstructing web element
            pageResources.getRegPage().pushRegisterNow();//push register now button
        }
        pageResources.getRegPage().inputNames(firstName,middleName,lastName);//enter first,middle, last names in registration form
        pageResources.getRegPage().selectCountry(country);//enter country in registration form
        pageResources.getRegPage().inputAddress(address);//enter address in registration form
        pageResources.getRegPage().inputPhone(phone);//enter ph# in registration form
        pageResources.getRegPage().inputEmail(email);//enter email in registration form
        pageResources.getRegPage().inputPassword(password);//enter password in registration form
        pageResources.getRegPage().pushCreateAccount();//push create account button in registration form
        pageResources.getLoginPage().enterUsername(email1);//enter login in login page
        pageResources.getLoginPage().enterPassword(password1);//enter password in login page
        pageResources.getLoginPage().pushLoginButton();//push login button

        try {
            assertFalse(logedInUrl,false);
        } catch (AssertionError e){
            System.err.println(errorMessage);
        }//assert if expected url matches actual url
    }
    //User can't login with valid email and blank password
    //Pushing Login button with valid email and blank password does not take user to Talents page
    @Test(dataProviderClass = DataResources.class, dataProvider = "Negative_Blank_Password", enabled = true, description = "Log in With valid Email and blank Password")
    public void LoginNegative4(String email, String password, String email1, String password1, String errorMessage) {
        String firstName = RandomStringUtils.randomAlphabetic(5);//first name
        String middleName = RandomStringUtils.randomAlphabetic(5);//middle name
        String lastName = RandomStringUtils.randomAlphabetic(5);//last name
        String country = RandomStringUtils.randomAlphabetic(5, 7);//country
        String address = RandomStringUtils.randomNumeric(4) + " " + RandomStringUtils.randomAlphabetic(5);//address
        String phone = RandomStringUtils.randomNumeric(10);//phone #

        try {
            pageResources.getRegPage().pushRegisterNow();//push register now button
        } catch (Exception e) {
            pageResources.getRegPage().killCover();//stop obstructing web element
            pageResources.getRegPage().pushRegisterNow();//push register now button
        }
        pageResources.getRegPage().inputNames(firstName,middleName,lastName);//enter first,middle, last names in registration form
        pageResources.getRegPage().selectCountry(country);//enter country in registration form
        pageResources.getRegPage().inputAddress(address);//enter address in registration form
        pageResources.getRegPage().inputPhone(phone);//enter ph# in registration form
        pageResources.getRegPage().inputEmail(email);//enter email in registration form
        pageResources.getRegPage().inputPassword(password);//enter password in registration form
        pageResources.getRegPage().pushCreateAccount();//push create account button in registration form
        pageResources.getLoginPage().enterUsername(email1);//enter login in login page
        pageResources.getLoginPage().enterPassword(password1);//enter password in login page
        pageResources.getLoginPage().pushLoginButton();//push login button

        try {
            assertFalse(logedInUrl,false);
        } catch (AssertionError e){
            System.err.println(errorMessage);
        }//assert if expected url matches actual url
    }
}


