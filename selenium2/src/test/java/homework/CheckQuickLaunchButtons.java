package homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class CheckQuickLaunchButtons {
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
    public void testCheckQuickLaunchButtons() throws Exception {
        String [] expected_footers =  {"Assign Leave", "Leave List", "Timesheets"};


        driver.get(baseUrl + "/symfony/web/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("Password");
        driver.findElement(By.id("btnLogin")).click();

        // Solution 1
        List<WebElement> all_button_footers = driver.findElements(
                By.xpath("//div[@id='dashboard-quick-launch-panel-menu_holder']//div[@class='quickLaunge']/a/img/following-sibling::*")
        );

        // Check that there are exactly 3 image footers
        assertEquals(
                "The actual number of footers did not match the expected number",
                3, all_button_footers.size());

        for (WebElement footer: all_button_footers) {
            String actual_footer = footer.getText();
            assertTrue(Arrays.asList(expected_footers).contains(actual_footer));
        }

        // Solution 2
        WebElement quickLaunch_container = driver.findElement(By.id("dashboard-quick-launch-panel-menu_holder"));
        List<WebElement> all_button_footers2 = quickLaunch_container.findElements(By.xpath(".//div[@class='quickLaunge']/a/img/following-sibling::*"));
        // Check that there are exactly 3 image footers
        assertEquals(
                "The actual number of footers did not match the expected number",
                3, all_button_footers2.size());

        ArrayList<String> actual_footers_list = new ArrayList<String>();
        for (WebElement footer: all_button_footers) {
            actual_footers_list.add(footer.getText());
        }

        String[] actual_footers = actual_footers_list.toArray(new String[actual_footers_list.size()]);
        Arrays.sort(actual_footers);
        assertArrayEquals(expected_footers, actual_footers);

        // Solution 3
        for (int i=0; i<3; i++) {
            String actual_footer = driver.findElement(By.xpath("(//div[@class='quickLaunge']/a/img/following-sibling::*)[" + (i+1) + "]")).getText();
            String expected_footer = expected_footers[i];
            assertTrue(actual_footer.equals(expected_footer));
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
