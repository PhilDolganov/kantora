
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Login {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,6);
        baseUrl = "http://hrm.seleniumminutes.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test() {
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("Password");
        driver.findElement(By.cssSelector("#btnLogin")).click();
        String actualWelcome = driver.findElement(By.cssSelector("#welcome")).getText();
        assertEquals("Welcome Admin", actualWelcome);
        driver.findElement(By.cssSelector("#welcome")).click();
        //driver.findElement(By.xpath("//li[3]/a[contains(text(),'Logout')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout"))).click();
        String loginpanel = driver.findElement(By.cssSelector("#logInPanelHeading")).getText();
        assertEquals("LOGIN Panel",loginpanel);
    }
    @Test
    public void invalidCredentials(){
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys(RandomStringUtils.randomAlphabetic(9));
        driver.findElement(By.cssSelector("#btnLogin")).click();
        String invalidPassword = driver.findElement(By.cssSelector("#spanMessage")).getText();
        assertEquals("Invalid credentials", invalidPassword);
    }
    @Test
    public void blankPassword(){
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
        driver.findElement(By.cssSelector("#btnLogin")).click();
        String blankPasword = driver.findElement(By.cssSelector("#spanMessage")).getText();
        assertEquals("Password cannot be empty", blankPasword);
    }
    @Test
    public void blankLogin(){
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("Password");
        driver.findElement(By.cssSelector("#btnLogin")).click();
        String blankLogin = driver.findElement(By.cssSelector("#spanMessage")).getText();
        assertEquals("Username cannot be empty", blankLogin);
    }

    private void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
          //  TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
