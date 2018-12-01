package tests;

import TestResources.BaseTest;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.assertEquals;

public class MenuTests extends BaseTest{
    @Test(priority = 0, description = "User navigates to dashboard page. Correct page displayed is validated")
    public void testDashboard(){
        pageResources.getDashboardPage().loadDashboardPage();
        assertEquals(pageResources.getDashboardPage().getHeader().trim(),"DASHBOARD");
    }
    @Test(priority = 1, description = "User navigates to Profile page. Correct page header displayed and 200 response code to page's URL are validated.")
    public void testProfile() throws IOException {
        pageResources.getDashboardPage().getProfile();
        assertEquals(pageResources.getDashboardPage().getHeader().trim(),"PROFILE");
        int responseCode = pageResources.getDashboardPage().validateUrl();
        assertEquals(responseCode, 200);
    }
    @Test(priority = 2, description = "User navigates to Sleep Guide page. Correct page header displayed and 200 response code to page's URL are validated.")
    public void testSleepGuide() throws IOException {
        pageResources.getDashboardPage().getSleepGuide();
        assertEquals(pageResources.getDashboardPage().getHeader().trim(), "SLEEP GUIDE");
        int responseCode = pageResources.getDashboardPage().validateUrl();
        assertEquals(responseCode, 200);
    }
    @Test(priority = 3, description = "User navigates to Sleep Report For Doctor page. Correct page header displayed and 200 response code to page's URL are validated.")
    public void testSleepReportForDoctor() throws IOException {
        pageResources.getDashboardPage().getSleepReportForDoctor();
        assertEquals(pageResources.getDashboardPage().getHeader().trim(), "SLEEP REPORT FOR DOCTOR");
        int responseCode = pageResources.getDashboardPage().validateUrl();
        assertEquals(responseCode, 200);
    }
    @Test(priority = 4, description = "User navigates to Weeks page. Correct page header displayed and 200 response code to page's URL are validated.")
    public void testWeeks() throws IOException {
        pageResources.getDashboardPage().getWeeks();
        assertEquals(pageResources.getDashboardPage().getHeader().trim(), "WEEKS");
        int responseCode = pageResources.getDashboardPage().validateUrl();
        assertEquals(responseCode, 200);
    }
    @Test(priority = 5, description = "User navigates to Nights page. Correct page header displayed and 200 response code to page's URL are validated.")
    public void testNights() throws IOException {
        pageResources.getDashboardPage().getNights();
        assertEquals(pageResources.getDashboardPage().getHeader().trim(), "NIGHTS");
        int responseCode = pageResources.getDashboardPage().validateUrl();
        assertEquals(responseCode, 200);
    }
}
