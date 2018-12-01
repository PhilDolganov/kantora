package com.com.datadriven.test;

import com.excel2.utility.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataDrivenTest {

    public static void main(String[] args){

        // get test data from excel
        Xls_Reader reader = new Xls_Reader("C:\\Users\\phild_000\\IdeaProjects\\practice2\\src\\test\\java\\com\\testdata\\HalfEbayTestData.xlsx");

        String firstName = reader.getCellData("RegistrationTestData", "firstname", 2);
        System.out.println(firstName);

        String lastName = reader.getCellData("RegistrationTestData", "lastname", 2);
        System.out.println(lastName);

        String address1 = reader.getCellData("RegistrationTestData", "address1", 2);
        System.out.println(address1);

        String address2 = reader.getCellData("RegistrationTestData", "address2", 2);
        System.out.println(address2);

        String city = reader.getCellData("RegistrationTestData", "city", 2);
        System.out.println(city);

        String state = reader.getCellData("RegistrationTestData", "state", 2);
        System.out.println(state);

        String zipCode = reader.getCellData("RegistrationTestData", "zipcode", 2);
        System.out.println(zipCode);

        String emailAddress = reader.getCellData("RegistrationTestData", "emailaddress", 2);
        System.out.println(emailAddress);

        // WebDriver code:
        WebDriver driver = new ChromeDriver();
        driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterinfo&usage=2943&ru="); // enter url
        driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address1);
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(address2);
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys(city);

        Select select = new Select(driver.findElement(By.xpath("//*[@id='state']")));
        select.selectByVisibleText(state);
        driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(zipCode.substring(0,5));
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//*[@id='retype_email']")).sendKeys(emailAddress);
    }
}
