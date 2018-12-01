package test;

import menus.MainMenu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.LocalizationPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocalizationTest extends AdminAuthenticateTest {
    private MainMenu mainMenu;
    private LocalizationPage localizationPage;
    private WebElement editSaveButton;

    @Before
    public void setUp() throws Exception {
        mainMenu = new MainMenu(driver);
        localizationPage = new LocalizationPage(driver);
    }
    @After
    public void backToEnglish(){
        String language = driver.findElement(By.tagName("lang")).getText();
        if (!language.equals("en"))
            editSaveButton.click();
        new Select(driver.findElement(By.id("localization_dafault_language"))).selectByIndex(1);
        editSaveButton.click();
    }
    @Test
    public void changeToChinese(){
        mainMenu.gotoLocalization();
        String header = localizationPage.getHeader();
        assertEquals("Localization",header);
        editSaveButton = driver.findElement(By.id("btnSave"));
        editSaveButton.click();
        new Select(driver.findElement(By.id("localization_dafault_language"))).selectByIndex(5);
        editSaveButton.click();
        assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".message.success"))).getText().contains("成功保存"));
        assertTrue(header.matches("[A-Za-z]+"));
        //assertTrue(editSaveButton.getAttribute("value").contains("编辑"));
        editSaveButton.click();
        new Select(driver.findElement(By.id("localization_dafault_language"))).selectByIndex(0);
        editSaveButton.click();
        assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".message.success"))).getText().contains("Successfully Saved"));
        assertTrue(driver.findElement(By.id("localization_dafault_language")).getText().contains("US English"));
        //assertTrue(editSaveButton.getAttribute("value").contains("Edit"));
    }

}
