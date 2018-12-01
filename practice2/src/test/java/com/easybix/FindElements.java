package com.easybix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FindElements {

    WebDriver driver;

    @Test
    public void openFacebook(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement lastName = driver.findElement(By.name("lastname"));
        WebElement dobLink = driver.findElement(By.partialLinkText("Why do I need to provide my"));
        WebElement phoneNumber = driver.findElement(By.cssSelector("input[name='reg_email__']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(lastName).click().sendKeys("Smith").build().perform();
        firstName.sendKeys("Phil");
        actions.moveToElement(dobLink).click().build().perform();
        phoneNumber.sendKeys("6666666");

    }
}
