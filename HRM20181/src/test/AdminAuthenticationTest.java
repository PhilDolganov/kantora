package test;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class AdminAuthenticationTest extends BaseTest {
    protected LoginPage loginPage;

    @Before
    public void setUpLogin() throws Exception {
        loginPage = new LoginPage(driver);
        loginPage.load();
        loginPage.login();
    }
}
