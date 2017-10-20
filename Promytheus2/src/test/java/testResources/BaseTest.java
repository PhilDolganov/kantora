package testResources;

import fabricator.Fabricator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    protected Fabricator fabricator;
    public String baseUrl;
    public String logedInUrl;
    public PageResources pageResources;
    public static final String USERNAME = "portnovtest";
    public static final String AUTOMATE_KEY = "e61af4a3-6c4a-4be9-89c4-1ee164d4e38e";
    public static final String URL1 = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    //@BeforeClass
    //public void remoteSetUp() throws MalformedURLException {


////    protected PageResources pageResources;
               // public PageResources pageResources;
////            DesiredCapabilities caps = DesiredCapabilities.iphone();
////            caps.setCapability("appiumVersion", "1.6.4");
////            caps.setCapability("deviceName", "iPhone 7 Plus Simulator");
////            caps.setCapability("deviceOrientation", "portrait");
////            caps.setCapability("platformVersion", "10.3");
////            caps.setCapability("platformName", "iOS");
////            caps.setCapability("browserName", "Safari");
////
////            driver = new RemoteWebDriver(new URL(URL1), caps);
//
      //  }
    @BeforeTest
    public void setUp() throws Exception {
        driver = new ChromeDriver();
       //pageResources = new PageResources(driver);
//        DesiredCapabilities caps = DesiredCapabilities.iphone();
//        caps.setCapability("appiumVersion", "1.6.4");
//        caps.setCapability("deviceName","iPhone 7 Plus Simulator");
//        caps.setCapability("deviceOrientation", "portrait");
//        caps.setCapability("platformVersion","10.3");
//        caps.setCapability("platformName", "iOS");
//        caps.setCapability("browserName", "Safari");



        //driver = new RemoteWebDriver(new URL(URL1), caps);
        pageResources = new PageResources(driver);
        wait = new WebDriverWait(driver, 5);
        baseUrl = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html";
        logedInUrl = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/talents.html";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);//go to home page
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //@AfterTest
//    public void tearDown () throws Exception {
//        driver.close();
//    }
//
    @AfterTest
    public void quit () throws Exception {
        driver.quit();
    }
}
