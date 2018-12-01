package com.easybix;

import org.testng.annotations.*;

public class AnnotationsExecutionOrder {

    @BeforeClass
    public void firstMethod(){
        System.out.println("In BeforeClass");
    }
    @AfterClass
    public void sixthMethod(){
        System.out.println("In AfterClass");
    }

    @BeforeMethod
    public void secondMethod(){
        System.out.println("In BeforeMethod");
    }
    @AfterMethod
    public void seventhMethod(){
        System.out.println("In AfterMethod");
    }

    @BeforeSuite
    public void thirdMethod(){
        System.out.println("In BeforeSuite");
    }
    @AfterSuite
    public void eighthMethod(){
        System.out.println("In AfterSuite");
    }

    @BeforeTest
    public void fourthMethod(){
        System.out.println("In BeforeTest");
    }
    @AfterTest
    public void ninthMethod(){
        System.out.println("In AfterTest");
    }

    @Test
    public void fifthMethod(){
        System.out.println("In Test");
    }
}
