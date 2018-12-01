package tests;

import TestResources.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class NavigationTests extends BaseTest {

    @Test(priority = 0, description = "User navigates to current month's sleep report. Correct month displayed on the report is validated")
    public void reportNavigationCurrentMonth(){
        assertEquals(pageResources.getDashboardPage().getActualCurrentMonth(),
                pageResources.getDashboardPage().getExpectedCurrentMonth());
    }
    @Test(priority = 1, description = "User navigates to previous month's sleep report. Correct month displayed on the report is validated")
    public void reportNavigationPreviousMonth(){
        assertEquals(pageResources.getDashboardPage().getPreviousMonth(), "January");
    }
    @Test(priority = 2, description = "User navigates to sleep report from 2 months ago. Correct month displayed on the report is validated")
    public void reportNavigation2MonthsAgo(){
        pageResources.getDashboardPage().getPreviousMonth();
        pageResources.getDashboardPage().pushPreviusMonth();
        assertEquals(pageResources.getDashboardPage().getActualCurrent(), "December");
    }
    @Test(priority = 3, description = "User navigates to sleep report from 3 months ago. Correct month displayed on the report is validated")
    public void reportNavigation3MonthsAgo(){
        pageResources.getDashboardPage().getPreviousMonth();
        pageResources.getDashboardPage().pushPreviusMonth();
        pageResources.getDashboardPage().pushPreviusMonth();
        assertEquals(pageResources.getDashboardPage().getActualCurrent(), "November");
    }
    @Test(priority = 4, description = "User navigates to sleep report from 4 months ago. Correct month displayed on the report is validated")
    public void reportNavigation4MonthsAgo(){
        pageResources.getDashboardPage().getPreviousMonth();
        pageResources.getDashboardPage().pushPreviusMonth();
        pageResources.getDashboardPage().pushPreviusMonth();
        pageResources.getDashboardPage().pushPreviusMonth();
        assertEquals(pageResources.getDashboardPage().getActualCurrent(), "October");
    }
    @Test(priority = 5, description = "User navigates to sleep report from 5 months ago. Correct month displayed on the report is validated")
    public void reportNavigation5MonthsAgo(){
        pageResources.getDashboardPage().getPreviousMonth();
        pageResources.getDashboardPage().pushPreviusMonth();
        pageResources.getDashboardPage().pushPreviusMonth();
        pageResources.getDashboardPage().pushPreviusMonth();
        pageResources.getDashboardPage().pushPreviusMonth();
        assertEquals(pageResources.getDashboardPage().getActualCurrent(), "September");
    }
}
