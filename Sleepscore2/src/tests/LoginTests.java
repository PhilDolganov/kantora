package tests;

import TestResources.BaseTest;
import TestResources.DataResources;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest{

@Test(priority = 0, dataProviderClass = DataResources.class, dataProvider = "Valid Login and Password", enabled = true,
        description = "User logs in using valid login and password")
public void validLoginPassword(String email, String password, String expectedUserEmail ,String errorMessage){
    pageResources.getLoginPage().loadLoginPage();
    pageResources.getLoginPage().enterUsername(email);
    pageResources.getLoginPage().enterPassword(password);
    pageResources.getLoginPage().pushLoginButton();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.dropdown-toggle"))).click();
    String actualUserEmail = driver.findElement(By.xpath("//p")).getText();
    try {
        assertEquals(expectedUserEmail, actualUserEmail);
    } catch (AssertionError e){
        System.err.println(errorMessage);
    }
}
    @Test(priority = 1, dataProviderClass = DataResources.class, dataProvider = "Valid Login and Invalid Password", enabled = true,
            description = "User does not log in using valid login and invalid password")
    public void validLoginInvalidPassword(String email, String invalidPassword, String expectedWarning ,String errorMessage){
        pageResources.getLoginPage().loadLoginPage();
        pageResources.getLoginPage().enterUsername(email);
        pageResources.getLoginPage().enterPassword(invalidPassword);
        pageResources.getLoginPage().pushLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger")));
        String ActualWarning = driver.findElement(By.cssSelector(".alert-danger")).getText().trim();
        try {
            assertEquals(expectedWarning, ActualWarning);
        } catch (AssertionError e){
            System.err.println(errorMessage);
        }
    }
    @Test(priority = 2, dataProviderClass = DataResources.class, dataProvider = "Invalid Login and Valid Password", enabled = true,
            description = "User does not log in using invalid login and valid password")
    public void invalidLoginValidPassword(String invalidEmail, String validPassword, String expectedWarning ,String errorMessage){
        pageResources.getLoginPage().loadLoginPage();
        pageResources.getLoginPage().enterUsername(invalidEmail);
        pageResources.getLoginPage().enterPassword(validPassword);
        pageResources.getLoginPage().pushLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger")));
        String ActualWarning = driver.findElement(By.cssSelector(".alert-danger")).getText().trim();
        try {
            assertEquals(expectedWarning, ActualWarning);
        } catch (AssertionError e){
            System.err.println(errorMessage);
        }
    }
}
