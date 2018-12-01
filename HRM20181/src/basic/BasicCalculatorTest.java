package basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BasicCalculatorTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "http://www.math.com/";
    private String[] numbers = "zero,one,two,three,four,five,six,seven,eight,nine".split(",");
    private String[] operations = {"plus","minus","times","div"};


@Before
public void setUp(){
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 5);
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get(baseUrl + "/students/calculators/source/basic.htm");
}

@After
    public void tearDown(){
    driver.quit();
}

@Test
    public void testCalculatorBasicSum(){
    long num1 = Math.round(Math.random() * 9);
    long num2 = Math.round(Math.random() * 9);

    String clickButton1 = numbers[(int) num1];
    String clickButton2 = numbers[(int) num2];

    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Input"))).clear();

    // Click first button randomly selected
    driver.findElement(By.name(clickButton1)).click();

    // Click plus (+) sign
    driver.findElement(By.name("plus")).click();

    // Click second button randomly selected
    driver.findElement(By.name(clickButton2)).click();

    // Click equal(=) sign
    driver.findElement(By.name("DoIt")).click();

    // Checks if result is equal
    Long expected = (num1 + num2);
    Long actual = Long.valueOf(driver.findElement(By.name("Input")).getAttribute("value"));
    assertEquals("Actual result '" + actual + "' did not equal expected value '" + expected + "'", expected,actual);
}

@Test
    public void testCalculatorRandomOperator(){
    String expected;

    long num1 = Math.round(Math.random() * 9);
    long num2 = Math.round(Math.random() * 9);
    String clickButton1 = numbers[(int) num1];
    String clickButton2 = numbers[(int) num2];
    String operButton = operations[(int) Math.floor(Math.random() * operations.length)];

    // Calculate expected result
    if (operButton.equals("plus")){
        expected = String.valueOf(num1 + num2);
    } else if (operButton.equals("minus")){
        expected = String.valueOf(num1 - num2);
    } else if (operButton.equals("times")){
        expected = String.valueOf(num1 * num2);
    } else {
        expected = (num2 == 0) ? "Infinity" : String.valueOf((double)num1 / num2);
    }

    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Input"))).clear();
    // Click first button randomly selected
    driver.findElement(By.name(clickButton1)).click();
    //Clicks chosen operation button
    driver.findElement(By.name(operButton)).click();
    // Click second button randomly selected
    driver.findElement(By.name(clickButton2)).click();
    // Click equal (=) sign
    driver.findElement(By.name("DoIt")).click();

    // Checks if actual result equals expected value
    String actual = driver.findElement(By.name("Input")).getAttribute("value");
    assertEquals("Actual result '"+ actual +"' did not equal expected value '"+ expected +"'" ,expected, actual);
}

@Test
    public void testCalculatorThreeDigitNumbers(){
    String expected;

    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Input"))).clear();

    // Select and enter first 3-digit number
    long d1 = Math.round(Math.random() * 9);
    long d2 = Math.round(Math.random() * 9);
    long d3 = Math.round(Math.random() * 9);
    long num1 = (d1 * 100)+(d2 * 10) + d3;

    driver.findElement(By.name(numbers[(int) d1])).click();
    driver.findElement(By.name(numbers[(int) d2])).click();
    driver.findElement(By.name(numbers[(int) d3])).click();

    // Select and click operation button
    String operButton = operations[(int) Math.floor(Math.random() * operations.length)];
    driver.findElement(By.name(operButton)).click();

    // Select and enter second 3-digit number
    d1 = Math.round(Math.random() * 9);
    d2 = Math.round(Math.random() * 9);
    d3 = Math.round(Math.random() * 9);
    long num2 = (d1 * 100)+(d2 * 10) + d3;

    driver.findElement(By.name(numbers[(int) d1])).click();
    driver.findElement(By.name(numbers[(int) d2])).click();
    driver.findElement(By.name(numbers[(int) d3])).click();

    // Click equal (=)
    driver.findElement(By.name("DoIt")).click();
    //Calculate expected result
    if (operButton.equals("plus")) {
        expected = String.valueOf(num1 + num2);
    }
    else if (operButton.equals("minus")) {
        expected = String.valueOf(num1 - num2);
    }
    else if (operButton.equals("times")) {
        expected = String.valueOf(num1 * num2);
    }
    else {
        expected = (num2 == 0) ? "Infinity" : String.valueOf((double)num1 / num2);
    }

    // Checks if actual result equals expected value
    String actual = driver.findElement(By.name("Input")).getAttribute("value");
    assertEquals("Actual result '"+ actual +"' did not equal expected value '"+ expected +"'" ,expected, actual);

}


@Test
    public void testCalculatorMultipleDigits(){
    String expected;

    long num1 = Math.round(Math.random() * 999);
    long num2 = Math.round(Math.random() * 999);

    String operButton = operations[(int) Math.floor(Math.random() * operations.length)];

    //Calculate expected result
    if (operButton.equals("plus")) {
        expected = String.valueOf(num1 + num2);
    }
    else if (operButton.equals("minus")) {
        expected = String.valueOf(num1 - num2);
    }
    else if (operButton.equals("times")) {
        expected = String.valueOf(num1 * num2);
    }
    else {
        expected = (num2 == 0) ? "Infinity" : String.valueOf((double)num1 / num2);
    }

    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Input"))).clear();

    // Enter first randomly selected number
    for (String digit: String.valueOf(num1).split("")) {
        driver.findElement(By.name(numbers[Integer.valueOf(digit)])).click();
    }

    // Click chosen operator button
    driver.findElement(By.name(operButton)).click();

    // Enter second randomly selected number
    for (String digit: String.valueOf(num2).split("")) {
        driver.findElement(By.name(numbers[Integer.valueOf(digit)])).click();
    }

    // Click equal (=)
    driver.findElement(By.name("DoIt")).click();

    // Checks if actual result equals expected value
    String actual = driver.findElement(By.name("Input")).getAttribute("value");
    assertEquals("Actual result '"+ actual +"' did not equal expected value '"+ expected +"'" ,expected, actual);
}

    @Test
    public void testCalculatorBasicSumByValue()
    {
        long num1 = Math.round(Math.random() * 9);
        long num2 = Math.round(Math.random() * 9);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Input"))).clear();
        //Click first button randomly selected
        driver.findElement(By.cssSelector("input[value='  "+num1+"  ']")).click();

        //Click plus (+) sign
        driver.findElement(By.name("plus")).click();

        //Click second button randomly selected
        driver.findElement(By.cssSelector("input[value='  "+num2+"  ']")).click();

        //Click equal (=) sign
        driver.findElement(By.name("DoIt")).click();

        //Check if result is equal
        Long expected = (num1 + num2);
        Long actual = Long.valueOf(driver.findElement(By.name("Input")).getAttribute("value"));
        assertEquals("Actual result '"+ actual +"' did not equal expected value '"+ expected +"'" ,expected, actual);
    }
}

