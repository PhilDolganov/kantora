package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class Tools {

    public static String getLastWindowHandle(WebDriver driver){
        Set<String> windowHandles = driver.getWindowHandles();
        String[] handlesArray = windowHandles.toArray(new String[windowHandles.size()]);

        return handlesArray[handlesArray.length - 1];
    }
    public static String getOriginalWindowHandle(WebDriver driver){
        Set<String> windowHandles = driver.getWindowHandles();
        String[] handlesArray = windowHandles.toArray(new String[windowHandles.size()]);

        return handlesArray[0];
    }
}
