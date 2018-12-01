package testResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TestPages;

public class PageResources {
    WebDriver driver;
    WebDriverWait wait;
    TestPages testPages;

    public PageResources(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }
    public TestPages getTestPages() {return testPages = new TestPages(driver);}//get test page
}
