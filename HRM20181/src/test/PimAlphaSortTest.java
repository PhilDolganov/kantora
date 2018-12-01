package test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.EmployeeInfoPage;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;


public class PimAlphaSortTest extends AdminAuthenticationTest {
    private EmployeeInfoPage pimPage;

    @Before
    public void setUp() {
        pimPage = new EmployeeInfoPage(driver);
    }
    @Test
    public void sortByFirstName() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("welcome")));
        pimPage.load();
        pimPage.sortByFirstName();

        String previous = "";
        while (true) {
            List<WebElement> allFirstNames = driver.findElements(By.xpath("//td[3]/a"));
            for (WebElement firstName : allFirstNames) {
                String current = firstName.getText();
                assertTrue("Expected '" +previous+ "' to be alphabetically before '"+ current + "'",
                        previous.compareToIgnoreCase(current) <= 0);
                previous = current;
            }
            String[] pagination;
            try {
                pagination = driver.findElement(By.cssSelector(".paging .desc")).getText().split(" ");
            } catch (NoSuchElementException e){
                break;
            }

            if (pagination[0].contains(pagination[pagination.length - 1])){
                break;
            }
            int pageNum = Integer.valueOf(driver.findElement(By.cssSelector("a.current")).getText());
            driver.findElement(By.linkText("Next")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class= 'current' and text()='"
                    + (pageNum + 1 ) + "']")));
        }
    }
}

