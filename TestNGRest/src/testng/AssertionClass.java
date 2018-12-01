package testng;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class AssertionClass {

    private Assertion hardAssert = new Assertion();
    private SoftAssert softAssert = new SoftAssert();

//    @Test
//    public void testHardAssert(){
//        System.out.println("I'm First Statement in Hard Assert");
//
//        hardAssert.assertEquals(3,3);
//        System.out.println("First Hard Assert is Passed");
//
//        hardAssert.assertEquals(1,2);
//        System.out.println("Second hard assert fails");
//    }

    @Test
    public void testSoftAssert(){
        System.out.println("I'm First Statement in Soft Assert");

        softAssert.assertEquals(3,3);
        System.out.println("First Soft Assert is Passed");

        softAssert.assertEquals(1,2);
        System.out.println("Second Soft assert fails");
    }

    @Test
    public void testSoftAssertVerifyAll(){
        System.out.println("I'm First Statement in Soft Assert");

        softAssert.assertEquals(3,3);
        System.out.println("First Soft Assert is Passed");

        softAssert.assertEquals(1,2);
        System.out.println("Second Soft assert fails");

        softAssert.assertAll();
    }
}
