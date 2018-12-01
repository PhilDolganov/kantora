package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverCommands {

    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        String url = "http://www.store.demoqa.com";
        driver.get(url);
        String title = driver.getTitle();
        int titleLength = driver.getTitle().length();
        System.out.println("Page title is : " + title);
        System.out.println("Title length is : " + titleLength);
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(url)){
            System.out.println("Verification Successful - The correct Url is opened.");
        } else {
            System.out.println("Verification Failed - an incorrect Url is opened.");
            // In case of Fail, you like to print the actual and expected URL for the record purpose
            System.out.println("Actual URL is : " + actualUrl);
            System.out.println("Expected URL is : " + url);
        }
        String pageSource = driver.getPageSource();
        int pageSourceLength = pageSource.length();
        System.out.println("Total length of the page source is: " + pageSourceLength);
        driver.close();


    }
}
