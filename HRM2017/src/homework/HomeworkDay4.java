package homework;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import test.AdminAuthenticateTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomeworkDay4 extends AdminAuthenticateTest {
    private String empId;

    @After
    public void tearDown() throws Exception {
        if (!empId.isEmpty()){
            driver.findElement(By.id("ohrmList_chkSelectRecord_" + (empId.substring(2)))).click();
            driver.findElement(By.id("btnDelete")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deleteConfModal")));
            driver.findElement(By.id("dialogDeleteBtn")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector(".message.success")));
        }
    }

    @Test
    public void enterEmployee(){
        String firstName = "Joe";
        String lastName = "Schmoe";
        String password = "123456789";

        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        empId = driver.findElement(By.id("employeeId")).getAttribute("value");
        driver.findElement(By.id("chkLogin")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_name"))).sendKeys(firstName + lastName);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.id("re_password")).sendKeys(password);
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("sidebar")).findElement(By.linkText("Job")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave"))).click();
        new Select(driver.findElement(By.id("job_job_title"))).selectByVisibleText("Cashier");
        new Select(driver.findElement(By.id("job_emp_status"))).selectByVisibleText("Employed");
        driver.findElement(By.id("btnSave")).click();
        assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(
        By.cssSelector(".message.success"))).getText().contains("Successfully Updated"));
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("empsearch_id"))).clear();
        driver.findElement(By.id("empsearch_id")).sendKeys(empId);
        driver.findElement(By.id("searchBtn")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#empsearch_id[value='" + empId + "']")));
        int size = driver.findElements(By.cssSelector("tbody>tr")).size();
        assertTrue("Search should return one row only", size == 1);
        assertEquals(firstName, driver.findElement(By.xpath("//*[@id='resultTable']//td[3]")).getText());
        assertEquals(lastName, driver.findElement(By.xpath("//*[@id='resultTable']//td[4]")).getText());
        assertEquals("Cashier", driver.findElement(By.xpath("//*[@id='resultTable']//td[5]")).getText());
        assertEquals("Employed", driver.findElement(By.xpath("//*[@id='resultTable']//td[6]")).getText());
    }
}
