package PageResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DashboardPage extends LoginPage {

    public DashboardPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".content-header>h1")
    WebElement header;

    public String getHeader(){
     return header.getText();
    }
    public void loadDashboardPage(){
        loadLoginPage();
        enterUsername("krishbharu@yahoo.co.in");
        enterPassword("Anselraj18");
        pushLoginButton();
        wait.until(ExpectedConditions.visibilityOf(header));
    }
    @FindBy(css = "li:nth-child(3) > a")
    WebElement profile;
    @FindBy(css = "li:nth-child(4) > a")
    WebElement sleepGuide;
    @FindBy(className = "treeview-sleepscore")
    //@FindBy(css = "li:nth-child(5) > a")
    WebElement sleepHistory;
    @FindBy(css = ".treeview :nth-child(1) > a")
    WebElement sleepReportForDoctor;
    @FindBy(css = ".treeview :nth-child(2) > a")
    WebElement weeks;
    @FindBy(css = ".treeview :nth-child(3) > a")
    WebElement nights;
    @FindBy(css = "text.highcharts-title")
    WebElement currentMonth;
    @FindBy(css = "div.controls-chart > button")
    WebElement navigatePreviousMonthButton;
    @FindBy(css = "div.controls-chart .pull-right")
    WebElement navigateNextMonthButton;

    public void pushProfileTab(){
    profile.click();
    }
    public void pushSleepGuideTab(){
    sleepGuide.click();
    }
    public void pushSleepHistoryTab(){
    sleepHistory.click();
    }

    public void pushSleepReportForDoctorTab(){
    pushSleepHistoryTab();
    wait.until(ExpectedConditions.visibilityOf(sleepReportForDoctor)).click();
}
    public void pushWeeksTab(){
        pushSleepHistoryTab();
        wait.until(ExpectedConditions.visibilityOf(weeks)).click();
    }
    public void pushNightsTab(){
        pushSleepHistoryTab();
        wait.until(ExpectedConditions.visibilityOf(nights)).click();
    }

    public void getProfile() {
        loadDashboardPage();
        pushProfileTab();
        System.out.print("Profile Menu: ");
    }
    public void getSleepGuide(){
        loadDashboardPage();
        pushSleepGuideTab();
        System.out.print("Sleep Guide Menu: ");
    }
    public void getSleepReportForDoctor(){
        loadDashboardPage();
        pushSleepHistoryTab();
        wait.until(ExpectedConditions.visibilityOf(sleepReportForDoctor));
        pushSleepReportForDoctorTab();
        System.out.print("Sleep Report For Doctor: ");
    }
    public void getWeeks(){
        loadDashboardPage();
        pushSleepHistoryTab();
        wait.until(ExpectedConditions.visibilityOf(weeks));
        pushWeeksTab();
        System.out.print("Weeks: ");
    }
    public void getNights(){
        loadDashboardPage();
        pushSleepHistoryTab();
        wait.until(ExpectedConditions.visibilityOf(nights));
        pushNightsTab();
        System.out.print("Nights: ");
    }

    public int validateUrl() throws IOException {
        String url = driver.getCurrentUrl();
        HttpURLConnection huc = (HttpURLConnection)(new URL(url).openConnection());
        huc.setRequestMethod("HEAD");
        huc.connect();
        int respCode = huc.getResponseCode();
        System.out.println(url + " Response code: "+ respCode);
        return respCode;
    }
    public String getActualCurrentMonth(){
        getWeeks();
        wait.until(ExpectedConditions.visibilityOf(currentMonth));
        String[] visibleDate =  currentMonth.getText().split(" ");
        String visibleMonth = visibleDate[0];
        return visibleMonth;
    }
    public String getExpectedCurrentMonth(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MMMMMMMMM");
        return formatter.format(date);
    }
    public String getPreviousMonth(){
        getWeeks();
        wait.until(ExpectedConditions.visibilityOf(currentMonth));
        navigatePreviousMonthButton.click();
        wait.until(ExpectedConditions.visibilityOf(currentMonth));
        String[] visibleDate =  currentMonth.getText().split(" ");
        String visibleMonth = visibleDate[0];
        return visibleMonth;
    }
    public void pushPreviusMonth(){
        navigatePreviousMonthButton.click();
        wait.until(ExpectedConditions.visibilityOf(currentMonth));
    }
    public String getActualCurrent() {
        wait.until(ExpectedConditions.visibilityOf(currentMonth));
        String[] visibleDate = currentMonth.getText().split(" ");
        String visibleMonth = visibleDate[0];
        return visibleMonth;
    }
}
