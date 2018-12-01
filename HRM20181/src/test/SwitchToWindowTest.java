package test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.Tools;

import java.util.Set;

import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SwitchToWindowTest extends AdminAuthenticationTest {
    private DashboardPage dashPage;

    @Before
    public void setUp(){
        dashPage = new DashboardPage(driver);
    }
    @Test
    public void testLogo() {
        WebElement logo = driver.findElement(By.cssSelector("#branding a img"));
        Dimension logoSize = logo.getSize();
 //       assertThat(logoSize, allOf())
        assertEquals(56, logoSize.height);
        assertTrue(283 == logoSize.width);

        Point logoLocation = logo.getLocation();
        // Only need y to test that it is at the top of the page.
        int topSection = 100;
        assertTrue(logoLocation.y+logoSize.height< topSection);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#branding>a').click()");

        //driver.findElement(By.cssSelector("#branding>a")).click();   // xpath: "//div[@id='branding']/a"
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        String[] handlesArray = windowHandles.toArray(new String[windowHandles.size()]);

        String lastWindow = handlesArray[handlesArray.length - 1];
        String originalWindow = handlesArray[0];

        driver.switchTo().window(lastWindow);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("firstline"))));
        assertEquals("The World's Most Popular HR Software", driver.findElement(By.id("firstline")).getText().trim());
        driver.close();
        driver.switchTo().window(originalWindow);
        assertTrue("Dashboard".equals(dashPage.getHeader()));

    }

    @Test
    public void testOpenNewWindow(){
        String href = driver.findElement(By.linkText("Leave List")).getAttribute("href");
        String command = "window.open('"+ href+"')";
        ((JavascriptExecutor)driver).executeScript(command);
        driver.switchTo().window(Tools.getLastWindowHandle(driver));
        assertEquals("Leave List", new BasePage(driver).getHeader());
        driver.close();
        driver.switchTo().window(Tools.getOriginalWindowHandle(driver));
    }
}
