import fabricator.Fabricator;
import fabricator.enums.DateFormat;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Logintest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    JavascriptExecutor ex;


    @FindBy(css = "#logoutForm > li > a[title='Log Out'][text='Log Out']")
    WebElement logout;
    @FindBy(css = "#Email [title='Email Address']")
    WebElement emailinp;
    @BeforeTest
    public void setUp() throws Exception {
        //System.setProperty("webdriver.gecko.driver", "geckodriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        baseUrl = "https://www.wellrx.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//    }

    @Test
    public void validLogin() {

        driver.get(baseUrl);
        driver.findElement(By.className("menuicon")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerLink"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName"))).sendKeys(RandomStringUtils.randomAlphabetic(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LastName"))).sendKeys(RandomStringUtils.randomAlphabetic(10));

        driver.findElement(By.id("ZipCode")).sendKeys(Fabricator.contact().postcode());
        int age = Fabricator.alphaNumeric().randomInt(13,100);

        driver.findElement(By.id("DateOfBirth")).sendKeys(Fabricator.contact().birthday(age, DateFormat.dd_MM_yyyy_BACKSLASH));
        String email = Fabricator.contact().eMail();
        driver.findElement(By.id("EmailAddress")).sendKeys(email);
        String password = Fabricator.alphaNumeric().botify("?????#####");
        driver.findElement(By.id("Password")).sendKeys(password);
        System.out.println(password);
        driver.findElement(By.id("btnSubmit")).click();
        driver.findElement(By.className("menuicon")).click();
        driver.findElement(By.className("right-off-canvas-menu")).findElement(By.id("logoutForm")).click();
        //((JavascriptExecutor)driver).executeScript("document.getElementById('logoutForm').submit()");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menuicon"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li:nth-child(13) > a"))).click();
        //driver.findElement(By.cssSelector("#Email [title='Email Address']")).sendKeys(email);
        //((JavascriptExecutor)driver).executeScript("document.getElementById('Email').click;");
        driver.findElement(By.cssSelector("#logInModal.open")).findElement(By.cssSelector("#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("#logInModal.open")).findElement(By.cssSelector("#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("#logInModal.open")).findElement(By.cssSelector("#btnSubmit")).click();


//        List<WebElement> links = driver.findElements(By.tagName("a"));
//        for (WebElement link : links){
//            System.out.println(link.getAttribute("href"));
 //       }



        //wait.until(ExpectedConditions.numberOfWindowsToBe(2));


        //String logwindow = driver.getWindowHandle();
//        driver.switchTo().window(logwindow);
//        sleep(5);
//        driver.findElement(By.id("Email")).sendKeys(email);
//        //driver.findElement(By.id("Email")).sendKeys(email);
//        //driver.findElement(By.id("Password")).clear();
//        driver.findElement(By.id("Password")).sendKeys(password);
//        driver.findElement(By.id("btnSubmit")).click();





        //ex = (JavascriptExecutor)driver;
        //ex.executeScript("arguments[0].click();",logout);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#logoutForm > li > a[title='Log Out'][text='Log Out']"))).click();



//        driver.findElement(By.id("btnLogin")).click();
//        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//        driver.findElement(By.id("txtPassword")).sendKeys("Password");
//
//        driver.findElement(By.id("btnLogin")).click();
//
//        String actualWelcome = driver.findElement(By.id("welcome")).getText();
//
//        assertEquals("Welcome Admin", actualWelcome);
//
//        // -- Log out
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.id("welcome"))).click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.linkText("Logout"))).click();

    }

    private void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}