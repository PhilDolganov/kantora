package homework;

import menus.MainMenu;
import org.junit.After;
import org.openqa.selenium.support.ui.Select;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LocalizationPage;
import test.AdminAuthenticateTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocalizationTestHW extends AdminAuthenticateTest {
    private MainMenu mainMenu;

    @Before
    public void setUp() throws Exception
    {
        mainMenu = new MainMenu(driver);
    }

    @After
    public void backToEnglish(){
        String language = driver.findElement(By.tagName("lang")).getText();
        if (!language.equals("en"))
            driver.findElement(By.id("btnSave")).click();
        new Select(driver.findElement(By.id("localization_dafault_language"))).selectByIndex(1);
        driver.findElement(By.id("btnSave")).click();
    }
    @Test
    public void test()
    {
        sleep(1);
        mainMenu.gotoLocalization();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("frmLocalization")));
        driver.findElement(By.id("btnSave")).click();

        new Select(driver.findElement(By.id("localization_dafault_language"))).selectByVisibleText("Chinese - China");

        driver.findElement(By.id("btnSave")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".message.success")));
        String messageText = (String) ((JavascriptExecutor)driver).executeScript("return document.querySelector('.message.success').firstChild.textContent");
        messageText = messageText.replaceAll("\\n", "");
        assertFalse("Message contained unexpected characters: '"+ messageText + "'", messageText.matches("[A-Za-z\\s]+"));

        assertFalse(driver.findElement(By.id("localizationHeading")).getText().matches("[A-Za-z]+"));

        driver.findElement(By.id("btnSave")).click();

        new Select(driver.findElement(By.id("localization_dafault_language"))).selectByVisibleText("US English");

        driver.findElement(By.id("btnSave")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#localization_dafault_language[disabled]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".message.success")));
        messageText = (String) ((JavascriptExecutor)driver).executeScript("return document.querySelector('.message.success').firstChild.textContent");
        messageText = messageText.replaceAll("\\n", "");
        assertTrue("Message contained unexpected characters: '"+ messageText + "'", messageText.matches("[A-Za-z\\s]+"));

        assertTrue(driver.findElement(By.id("localizationHeading")).getText().matches("[A-Za-z]+"));



    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
