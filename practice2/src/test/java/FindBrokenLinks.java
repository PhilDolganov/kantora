import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FindBrokenLinks {
    public static List findAllLinks(WebDriver driver){
        List<WebElement> elementList = new ArrayList();
        elementList  = driver.findElements(By.tagName("a"));
        elementList.addAll(driver.findElements(By.tagName("img")));
        List finalList = new ArrayList();
        for (WebElement element : elementList){
            if (element.getAttribute("href") != null){
                finalList.add(element);
            }
        }
        return finalList;
    }
    public static String isLinkBroken(URL url) throws Exception {
        //url = new URL("http://yahoo.com");
        String response = "";
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        try {
            connection.connect();
            response = connection.getResponseMessage();
            connection.disconnect();
            return response;
        } catch (Exception e){
            return e.getMessage();
        }
    }
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
        //driver.get("http://www.yahoo.com");
        List<WebElement> allImages = findAllLinks(driver);
        System.out.println("Total number of elements found " + allImages.size());
        for (WebElement element : allImages){
            try {
                System.out.println("URL: " + element.getAttribute("href")+
                        " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
            } catch (Exception e){
                System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + e.getMessage());
            }
        }
    }
}
