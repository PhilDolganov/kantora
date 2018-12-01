package com.Portnov;

import org.junit.*;
import static org.junit.Assert.*;

public class Template {
    @BeforeClass
    public static void oneTimeSetUp(){
        System.out.println("before class");
    }
    @Before
    public void setUp(){
        System.out.println("before");
    }
    @Test
    public void test1(){
        assertEquals("this is 1 + 1",3, 1 + 1);
        System.out.println("test1");
    }
    @Test
    public void test2(){
        assertTrue("this assertion condition",3 == (1 + 1));
        System.out.println("test2");
    }
    @After
    public void tearDown(){
        System.out.println("after");
    }
    @AfterClass
    public static void oneTimeTearDown(){
        System.out.println("after class");
    }
}
