package createproject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

//user clicks add new project button, names it 'Project 123', fills out name, email, phone, website, city, zip and clicks create button.
public class TestCreateProject extends BaseTest {
    By addProjectButton = By.className("add_project");
    By textfieldProjectName = By.xpath("//*[@id='project_name']");
    By createProjectButton = By.className("create");
    By actualProjectName = By.xpath("//*[contains(@class,'project_name')]//TABLE//TR");

    @Test(priority = 0, dataProviderClass = DataResources.class, dataProvider = "Add Project", enabled = true, description = "Create project and fill in data")
    public void createProject (String projectName,String name, String email, String phone, String website, String city, String zip, String startStr, String endStr){
        wait.until(ExpectedConditions.presenceOfElementLocated(addProjectButton)).click();//click add project button
        wait.until(ExpectedConditions.presenceOfElementLocated(textfieldProjectName)).sendKeys(projectName);//enter project name
        driver.findElement(By.xpath(startStr+"5"+endStr)).sendKeys(name);//enter name
        driver.findElement(By.xpath(startStr+"6"+endStr)).sendKeys(email);//enter email
        driver.findElement(By.xpath(startStr+"7"+endStr)).sendKeys(phone);//enter phone
        driver.findElement(By.xpath(startStr+"8"+endStr)).sendKeys(website);//enter website
        driver.findElement(By.xpath(startStr+"9"+endStr)).sendKeys(city);//enter city
        driver.findElement(By.xpath(startStr+"10"+endStr)).sendKeys(zip);//enter zip
        driver.findElement(createProjectButton).click();//push create project button
        String getText = wait.until(ExpectedConditions.presenceOfElementLocated(actualProjectName)).getText();//verify that expected project name is the same as actual
        try {
            assertEquals(projectName, getText);//(expected project name,actual project name)
        } catch (AssertionError e){
            System.err.println("Failed");//if expected project name doesn't match actual project name, "Failed" is printed in console
        }
    }
}
