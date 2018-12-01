package executeFailedTests;

import org.testng.annotations.Test;

public class SampleTestClass2 {

    @Test
    public void thirdTest(){
        System.out.println("My Third Test");
    }

    @Test
    public void fourthTest(){
        int i = 1/0;
        System.out.println("My Fourth Test");
    }
}
