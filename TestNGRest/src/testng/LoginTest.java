package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeTest
    public void invokeApplication(){
        driver = new ChromeDriver();
        driver.get("https://facebook.com");
    }


    @Test(dataProvider = "getData")
    public void testLogin(String userName, String passWord){
        System.out.println(userName);
    }

    @Test(dataProvider = "getData")
    public void loginFaceBook(String userName, String passWord){
        WebElement firstName = driver.findElement(By.name("firstname"));
        WebElement lastName = driver.findElement(By.name("lastname"));

        firstName.clear();
        lastName.clear();

        firstName.sendKeys(userName);
        lastName.sendKeys(passWord);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] dataSet = new Object[4][2];

        dataSet[0][0] = "anshul";
        dataSet[0][1] = "Anshul123";

        dataSet[1][0] = "Alex";
        dataSet[1][1] = "Alex123";

        dataSet[2][0] = "Merilla";
        dataSet[2][1] = "Merilla123";

        dataSet[3][0] = "Jason";
        dataSet[3][1] = "Jason123";

        return dataSet;
    }

    @AfterTest
    public void closeApplication(){
        driver.close();
    }
}
