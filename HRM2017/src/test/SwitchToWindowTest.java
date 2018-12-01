package test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.DashboardPage;
import utils.Tools;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SwitchToWindowTest extends AdminAuthenticateTest {
    private DashboardPage dashPage;
    private WebElement logo;

    @Before
    public void setUp() throws Exception {
        dashPage = new DashboardPage(driver);
    }
    @Test
    public void testLogo(){

        logo = driver.findElement(By.cssSelector("#branding a img"));
        Dimension logoSize = logo.getSize();
 //       assertThat(logoSize, allOf())
        assertEquals(56, logoSize.height);
        assertTrue(283 == logoSize.width);
        Point logoLocation = logo.getLocation();
        // only need Y to test that it is a t the top of the page
        int topSection = 100;
        assertTrue(logoLocation.y + logoSize.height < topSection);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#branding>a').click()");
        //driver.findElement(By.cssSelector("#branding>a")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        // xpath "//div[@id = 'branding']/a"
        Set<String> windowHandles = driver.getWindowHandles();
        String[] handlesArray = windowHandles.toArray(new String[windowHandles.size()]);
        String lastWindow = handlesArray[handlesArray.length - 1];
        String originalWindow = handlesArray[0];
        driver.switchTo().window(lastWindow);
        assertEquals("The World's Most Popular HR Software", driver.findElement(By.id("firstline")).getText().trim());
        driver.close();
        driver.switchTo().window(originalWindow);
        assertTrue("Dashboard".equals(dashPage.getHeader()));
    }

    @Test
    public void testOpenNewWindow(){
        String href = driver.findElement(By.linkText("Leave List")).getAttribute("href");
        String command = "window.open('" + href + "')";

        ((JavascriptExecutor)driver).executeScript(command);
        driver.switchTo().window(Tools.getLastWindowHandle(driver));
        assertEquals("Leave List", new BasePage(driver).getHeader());
        driver.close();
        driver.switchTo().window(Tools.getOriginalWindowHandle(driver));
    }
}
