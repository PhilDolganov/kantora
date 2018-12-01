package test;

import menus.MainMenu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.EmailNotificationPage;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class MenuTest extends AdminAuthenticateTest {
    private MainMenu mainMenu;
    private EmailNotificationPage emailNotification;

    @Before
    public void setUp()throws Exception {
        mainMenu = new MainMenu(driver);
        emailNotification = new EmailNotificationPage(driver);
    }
    @Test
    public void test() {
        // login
        // menu -> emailSubscriptions
        // check header

        mainMenu.gotoEmailSubscriptions();
        String pageHeader = emailNotification.getHeader();
        assertEquals("Email Notification", pageHeader);
    }
}
