package homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CheckRowStyles {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://hrm.seleniumminutes.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCheckRowStyles() throws Exception {
        driver.get(baseUrl + "/symfony/web/index.php/auth/login");
        driver.findElement(By.cssSelector("span.form-hint")).click();
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("Password");
        driver.findElement(By.id("btnLogin")).click();

//	Basic Example
        driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b")).click();
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();

//  Actions Un-chained Example
//    Actions action = new Actions(driver);
//    action.moveToElement(driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b")));
//    action.click(driver.findElement(By.id("menu_pim_viewEmployeeList")));
//    action.perform();

//  Action Chain Example
//    Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b")))
//				.click(driver.findElement(By.id("menu_pim_viewEmployeeList")))
//				.perform();

        // Solution 1
        List<WebElement> all_even_rows = driver.findElement(By.id("resultTable")).findElements(By.xpath(".//tr[(position() mod 2)=0]"));
        for (WebElement row: all_even_rows) {
            String row_type = row.getAttribute("class");
            assertEquals("Row style did not match the expected 'even' style.", "even", row_type);
        }

        // Solution 2
        List<WebElement> all_odd_rows = driver.findElement(By.id("resultTable")).findElements(By.cssSelector("tbody>tr:nth-child(odd)"));
        for (WebElement row: all_odd_rows) {
            String row_type = row.getAttribute("class");
            assertEquals("Row style did not match the expected 'odd' style.", "odd", row_type);
        }

        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
