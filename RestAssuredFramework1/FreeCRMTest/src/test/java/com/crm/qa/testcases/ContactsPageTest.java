package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    String sheetName = "contacts";

    public ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        homePage.clickOnContactsLink();
    }


    @Test(priority = 7)
    public void verifyContactsPageLabel() {
        assertTrue(contactsPage.verifyContactLabel(), "contacts label is missing on the page");
    }

    @Test(priority = 8)
    public void selectSingleContactsTest() {
        contactsPage.selectContactsByName("Aamy Aadams");
    }

    @Test(priority = 9)
    public void selectMultipleContactsTest()  {
        contactsPage.selectContactsByName("Aashley Aaskers ");
        contactsPage.selectContactsByName("Atika Bhatt ");
    }

    @DataProvider
    public Object[][] getCRMTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }
    @Test(priority = 10, dataProvider = "getCRMTestData")
    public void validateCreateNewContact(String title, String firstName, String lastName, String company)  {
        homePage.clickOnNewContactLink();
        //contactsPage.createNewContact("Mr.","Akakiy", "Akopyan", "Armenian Radio");
        contactsPage.createNewContact(title,firstName,lastName,company);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
