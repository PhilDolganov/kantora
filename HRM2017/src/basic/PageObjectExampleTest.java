package basic;

import org.junit.Before;
import org.junit.Test;
import pages.DashboardPage;
import test.AdminAuthenticateTest;
import static org.junit.Assert.assertEquals;

public class PageObjectExampleTest extends AdminAuthenticateTest {
    private DashboardPage homePage;

    @Before
    public void setUp() throws Exception {
        homePage = new DashboardPage(driver);
    }

    @Test
    public void test(){
        String actualWelcome = homePage.getWelcomeMessage();
        assertEquals("Welcome Admin", actualWelcome);
        homePage.logout();
    }
}
