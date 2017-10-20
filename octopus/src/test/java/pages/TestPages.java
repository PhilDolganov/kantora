package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class TestPages {
    WebDriver driver;
    WebDriverWait wait;
    public TestPages(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "shirt")
    WebElement tShirtListbox;//T-shirt list box
    @FindBy(id = "theText")
    WebElement valueTextField;//Text field with T-shirt values

    public void sum(int arg1,int arg2){
        int result = arg1+arg2;//add 2 values and get result
        System.out.println("Calculating using formula:("+ arg1+"+"+arg2+")="+result);//print formula
        System.out.println("Returning result: "+result);//print result
        String finalValue = "0000000"+result;//print final value
        Select tshirtList = new Select(tShirtListbox);
        tshirtList.selectByValue(finalValue);//select from T-shirt listbox by final value
        System.out.println("Selecting answer, from result, by value "+result);
        try{
            assertEquals(finalValue,getSelectedValue());//compare expected and actual results
            System.out.println("Selected 'Live Octopus', using value "+finalValue);//print Live Octopus when expected result matches actual result
            System.out.println("----------------------------------------------");
        } catch (AssertionError e){
            System.out.println("Result doesn't match");//print error when expected result doesn't match actual result
        }
    }
    public void addSubtract(int arg1, int arg2, int arg3){
        int result = (arg1+arg2)-arg3;//add 2 values, subtract third value and get result
        System.out.println("Calculating using formula:(("+ arg1+"+"+arg2+")-"+arg3+")="+result);//print formula
        System.out.println("Returning result: "+result);//print result
        String finalValue = "0000000"+result;//print final value
        Select tshirtList = new Select(tShirtListbox);
        tshirtList.selectByValue(finalValue);//select from T-shirt listbox by final value
        System.out.println("Selecting answer, from result, by value "+result);
        try{
            assertEquals(finalValue,getSelectedValue());//compare expected and actual results
            System.out.println("Selected 'Live Octopus', using value "+finalValue);//print Live Octopus when expected result matches actual result
            System.out.println("----------------------------------------------");
        } catch (AssertionError e){
            System.out.println("Result doesn't match");//print error when expected result doesn't match actual result
        }
    }
    public void multiplySubtract(int arg1, int arg2, int arg3){
        int result = (arg1*arg2)-arg3;//multiply two values, subtract 3rd value and get result
        System.out.println("Calculating using formula:(("+ arg1+"*"+arg2+")-"+arg3+")="+result);//print formula
        System.out.println("Returning result: "+result);//print result
        String finalValue = "0000000"+result;//print final value
        Select tshirtList = new Select(tShirtListbox);
        tshirtList.selectByValue(finalValue);//select from T-shirt listbox by final value
        System.out.println("Selecting answer, from result, by value "+result);
        try{
            assertEquals(finalValue,getSelectedValue());//compare expected and actual results
            System.out.println("Selected 'Live Octopus', using value "+finalValue);//print Live Octopus when expected result matches actual result
            System.out.println("----------------------------------------------");
        } catch (AssertionError e){
            System.out.println("Result doesn't match");//print error when expected result doesn't match actual result
        }
    }

    public void multiplyDivideSubtract(int arg1, int arg2, int arg3, int arg4){
        int result = (((arg1*arg2)/arg3)-arg4);//multiply two values, divide by third value, subtract forth value and get result
        System.out.println("Calculating using formula:((("+arg1+"*"+arg2+")/"+arg3+")-"+arg4+")="+result);//print formula
        System.out.println("Returning result: "+result);//print result
        String finalValue = "0000000"+result;//print final value
        Select tshirtList = new Select(tShirtListbox);
        tshirtList.selectByValue(finalValue);//select from T-shirt listbox by final value
        System.out.println("Selecting answer, from result, by value "+result);
        try{
            assertEquals(finalValue,getSelectedValue());//compare expected and actual results
            System.out.println("Selected 'Live Octopus', using value "+finalValue);//print Live Octopus when expected result matches actual result
            System.out.println("----------------------------------------------");
        } catch (AssertionError e){
            System.out.println("Result doesn't match");//print error when expected result doesn't match actual result
        }
    }

    public void selectRedTshirt(){//select Red T-shirt method
        Select tshirtList = new Select(tShirtListbox);
        tshirtList.selectByVisibleText("Red T-Shirt");
        System.out.println("Selected Red with a value of "+getSelectedValue());
    }

    public void selectYellowTshirt(){//select Yellow T-shirt method
        Select tshirtList = new Select(tShirtListbox);
        tshirtList.selectByVisibleText("Yellow T-Shirt");
        System.out.println("Selected Yellow with a value of "+getSelectedValue());
    }

    public void selectBlueTshirt(){//select Blue T-shirt method
        Select tshirtList = new Select(tShirtListbox);
        tshirtList.selectByVisibleText("Blue T-Shirt");
        System.out.println("Selected Blue with a value of "+getSelectedValue());
    }

    public void selectGreenTshirt(){//select Green T-shirt method
        Select tshirtList = new Select(tShirtListbox);
        tshirtList.selectByVisibleText("Green T-Shirt");
        System.out.println("Selected Green with a value of "+getSelectedValue());
    }

    public String getSelectedValue(){//get selection value from T-shirt text field
        return valueTextField.getAttribute("value");
    }
}
