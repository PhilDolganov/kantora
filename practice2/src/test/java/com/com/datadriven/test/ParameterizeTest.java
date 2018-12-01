package com.com.datadriven.test;

import com.excel2.utility.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Properties;

public class ParameterizeTest {

    public static void main(String[] args){


        String workingDirectory = System.getProperty("user.dir");
        String resourceFilePath = workingDirectory + "/src/test/java/com/" + "testdata/" + "HalfEbayTestData.xlsx";

        // WebDriver code:
        WebDriver driver = new ChromeDriver();
        driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterinfo&usage=2943&ru="); // enter url

        //Data Driven Approach -- used to create data driven framework

        //get test data from excel:
        //Xls_Reader reader = new Xls_Reader("C:\\Users\\phild_000\\IdeaProjects\\practice2\\src\\test\\java\\com\\testdata\\HalfEbayTestData.xlsx");
        Xls_Reader reader = new Xls_Reader(resourceFilePath);
        int rowCount = reader.getRowCount("RegistrationTestData");

        reader.addColumn("RegistrationTestData", "status");



        //parameterization:
        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
            System.out.println("================");
            String firstName = reader.getCellData("RegistrationTestData", "firstname", rowNum);
            System.out.println(firstName);

            String lastName = reader.getCellData("RegistrationTestData", "lastname", rowNum);
            System.out.println(lastName);

            String address1 = reader.getCellData("RegistrationTestData", "address1", rowNum);
            System.out.println(address1);

            String address2 = reader.getCellData("RegistrationTestData", "address2", rowNum);
            System.out.println(address2);

            String city = reader.getCellData("RegistrationTestData", "city", rowNum);
            System.out.println(city);

            String state = reader.getCellData("RegistrationTestData", "state", rowNum);
            System.out.println(state);

            String zipCode = reader.getCellData("RegistrationTestData", "zipcode", rowNum);
            System.out.println(zipCode);

            String emailAddress = reader.getCellData("RegistrationTestData", "emailaddress", rowNum);
            System.out.println(emailAddress);

           // Enter data

            driver.findElement(By.xpath("//*[@id='firstname']")).clear();
            driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstName);

            driver.findElement(By.xpath("//*[@id='lastname']")).clear();
            driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastName);

            driver.findElement(By.xpath("//*[@id='address1']")).clear();
            driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address1);

            driver.findElement(By.xpath("//*[@id='address2']")).clear();
            driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(address2);

            driver.findElement(By.xpath("//*[@id='city']")).clear();
            driver.findElement(By.xpath("//*[@id='city']")).sendKeys(city);

            Select select = new Select(driver.findElement(By.xpath("//*[@id='state']")));
            select.selectByVisibleText(state);

            driver.findElement(By.xpath("//*[@id='zip']")).clear();
            driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(zipCode.substring(0,5));

            driver.findElement(By.xpath("//*[@id='email']")).clear();
            driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emailAddress);

            driver.findElement(By.xpath("//*[@id='retype_email']")).clear();
            driver.findElement(By.xpath("//*[@id='retype_email']")).sendKeys(emailAddress);

            reader.setCellData("RegistrationTestData","status",rowNum,"Pass"); // write the data into a cell
        }
    }
}
