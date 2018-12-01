package testng;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTest {

    @Test
    public void firstTest(){
        System.out.println("this is my first test");
    }
    @Test
    public void secondTest() {
        if (false) {
            System.out.println("this is my second test");
        } else {
            throw new SkipException("Login Failed");
        }
    }

    @Test(enabled = false)
    public void thirdTest(){
        System.out.println("this is my third test");
    }
}
