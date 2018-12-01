package com.Portnov;

import org.junit.*;
import static org.junit.Assert.*;

public class TestCalculator {

    private Calculator calc;

    @Before
    public void setUp(){
        calc = new Calculator();
        calc.switchOn();
    }
    @Test
    public void test(){

        calc.add(10);
        calc.add(20);
        assertEquals(30,calc.getResult());
    }

    @Test
    public void test2(){

        calc.add(-10);
        calc.add(-20);
        assertEquals(-30,calc.getResult());
    }
    @Test
    public void test3(){
        calc.add(10);
        calc.subtract(5);
        assertEquals(5,calc.getResult());
    }
    @Test
    public void test4(){
        calc.add(-10);
        calc.subtract(-5);
        assertEquals(-5,calc.getResult());
    }
}
