package createproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new ChromeDriver();//instantiating chrome driver
        wait = new WebDriverWait(driver, 5);//explicit wait
        driver.get(baseUrl);//go to home page
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void quit () throws Exception {
        driver.quit();//close browser after test
    }
}
