package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class LoginTests extends BaseTest {
    String pageUrl = "https://portal-systest.azurewebsites.net/login";
    String login = "krishbharu@yahoo.co.in";
    String password = "Anselraj18";
    String invalidPassword = password.substring(1);
    String invalidPassword2 = "Anselraj1";


    @Before
    public void setUp(){
    driver.get(pageUrl);

    }
    @After
    public void tearDown(){

    }

    @Test
    public void vaildCredentials(){
        driver.findElement(By.id("loginInputEmail")).sendKeys(login);
        driver.findElement(By.id("loginInputPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("#form-login > button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.dropdown-toggle"))).click();
        String actualName = driver.findElement(By.xpath("//p")).getText();
        assertEquals(login, actualName);
    }
    @Test
    public void invalidPass(){
        driver.findElement(By.id("loginInputEmail")).sendKeys(login);
        driver.findElement(By.id("loginInputPassword")).sendKeys(invalidPassword2);
        driver.findElement(By.cssSelector("#form-login > button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger")));
        String warning = driver.findElement(By.cssSelector(".alert-danger")).getText();
        System.out.print(warning);
    }

//    @Test
//    public void invalidPassword(){
//        driver.findElement(By.id("loginInputEmail")).sendKeys(login);
//        driver.findElement(By.id("loginInputPassword")).sendKeys(invalidPassword);
//        driver.findElement(By.cssSelector("#form-login > button")).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated())

    }



