


import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;



    @RunWith(Parameterized.class)
    public class DDYahooUsernameHW3 {
        private WebDriver driver;
        private String baseUrl;
        private String yahooID;
        private String last_name;
        private String first_name;
        private String expected_message;
        private JavascriptExecutor js;

        public DDYahooUsernameHW3(String first_name, String last_name, String yahooID,
                                  String expected_message) {
            super();
            this.yahooID = yahooID;
            this.last_name = last_name;
            this.first_name = first_name;
            this.expected_message = expected_message;
        }

        @Parameters
        public static Collection<Object[]>	data() {
            return Arrays.asList(new Object[][] { { "Steve", "Jobs", "abc", "Your username must be at least 4 characters long." },
                    {"Ellie", "Skobel", "abcd", "That username is not available."},
                    {"Dotty", "Smith", "1234", "Your username must begin with a letter."},
                    {"Manny", "Worts", "a b c d", "Only letters, numbers, underscores, and one period are allowed."},
                    {"Colorful", "Stripes", "a._b", "Consecutive underscores or periods are not allowed."},
                    {"Happy", "Man", "a.b.c.d", "Only one period is allowed."},
                    {"Goanne", "Getthem", "abc.", "Your username cannot end in an underscore or a period."}
            });
        }

        @Before
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            //baseUrl = "https://edit.yahoo.com";
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        @After
        public void tearDown() throws Exception {
            driver.quit();
        }

        @Test
        public void testDDYahooUsernameHW3() throws Exception {
            driver.get("https://login.yahoo.com/account/create?src=ym&intl=us&done=https%3A%2F%2Fmail.yahoo.com%2F&specId=yidReg");
            assertEquals("Yahoo", driver.getTitle());
//    driver.findElement(By.id("first-name")).click();
            type(By.id("first-name"), first_name);
            type(By.id("last-name"), last_name);

            WebElement element = driver.findElement(By.id("user-name"));

            // Example of method overloading
            type(element, yahooID);
            type(By.id("password"), "");
            pause(200);
            assertEquals(expected_message, driver.findElement(By.id("user-name-validation-message")).getText());
        }

        private void type(By locator, String str) {
            WebDriver browser = getBrowser();
            WebElement element = browser.findElement(locator);
            element.clear();
            element.sendKeys(str);
        }

        private void type(WebElement element, String str) {
            element.clear();
            element.sendKeys(str);
        }

        private WebDriver getBrowser() {
            if (driver == null) {
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
            return driver;
        }

        private JavascriptExecutor getJavascriptExecutor() {
            if (js == null) {
                js = (JavascriptExecutor) getBrowser();
            }
            return js;
        }

        private void pause(long ms) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                return;
            }
        }
    }


