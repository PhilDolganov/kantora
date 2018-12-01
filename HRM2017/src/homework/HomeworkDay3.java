package homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.AdminAuthenticateTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomeworkDay3 extends AdminAuthenticateTest {

    @Test
    public void empSearch() throws Exception {
        //Part A: Search by employee name
        //1) Go to hrm.seleniumminutes.com
        //2) Login: admin/Password
        //3) CLick the PIM tab in the top left corner
        //4) In the Employee Name field enter the name 'Smith'
        //5) Click the Search button
        //6) Check that the first row of the results table contains an employee with last name 'Smith'
        //Hint: Don't forget to wait where appropriate!
        //We will discuss how to use WebDriverWait in the next class, but for now please use sleep() as a temporary solution.
        String expected = "Smith";
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        WebElement empNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#empsearch_employee_name_empName.inputFormatHint")));
        empNameField.clear();
        empNameField.sendKeys(expected );
        //sleep(1);
        empNameField.sendKeys(Keys.ESCAPE);
        driver.findElement(By.id("searchBtn")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input#empsearch_employee_name_empName[value='Smith']")));
        String lastName = driver.findElement(By.xpath("//*[@id='resultTable']//td[4]/a")).getText();
        assertEquals(expected, lastName);
        //Part B: this part is optional since we have not yet tried this out in class together
        //7) Implement a for-loop to check that all rows within the results table contain employees with the last name 'Smith'

        List<WebElement> allLastNameElements = driver.findElements(By.xpath("//*[@id='resultTable']//td[4]/a"));
        for (WebElement el: allLastNameElements) {
            String name = el.getText();
            assertTrue(name.contains(expected));
        }

        //Extra Challenge: (because we have to yet discussed how to do this)
        //8) Modify your code to search by employee name 'Smith' and by Job Title 'QA Manager'
        //9) Check that each resulting row contains an employee with last name 'Smith' that is also a 'QA Manager'
        //Hint: https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/Select.html

        new Select(driver.findElement(By.id("empsearch_job_title"))).selectByVisibleText("Cashier");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBtn"))).click();
        //driver.findElement(By.id("searchBtn")).click();

        List<WebElement> allRowElements = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));
        for (WebElement el: allRowElements) {
            String name = el.findElement(By.xpath("//td[4]/a")).getText();
            String jobTitle = el.findElement(By.xpath("//td[5]")).getText();
            assertTrue(name.contains(expected));
            assertEquals("Cashier", jobTitle);
        }
    }

//    private void sleep(int seconds){
//        try {
//            Thread.sleep(seconds * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            // TODO Auto generated catch block
//        }
//    }
}
