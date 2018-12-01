package test;

import menus.MainMenu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.EmailNotificationPage;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class MenuTest extends BaseTest {

    private LoginPage loginPage;
    private MainMenu mainMenu;
    private EmailNotificationPage emailNotificationPage;


    @Before
    public void setUp() throws Exception {
        loginPage = new LoginPage(driver);
        mainMenu = new MainMenu(driver);
        emailNotificationPage = new EmailNotificationPage(driver);
    }
    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void test(){
        // login
        // menu -> emailSubscriptions
        // check header

        loginPage.load();
        loginPage.login();
        mainMenu.gotoEmailSubscriptions();

        String pageHeader = emailNotificationPage.getHeader();
        assertEquals("Email Notification",pageHeader);
    }
}
