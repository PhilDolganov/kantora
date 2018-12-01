package com.Portnov;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class DDT {
    private Calculator calc;

    @Before
    public void setUp(){
        calc = new Calculator();
        calc.switchOn();
    }
    @Test
    @FileParameters(value = "file:C:/Users/phild_000/IdeaProjects/addition.csv", mapper = CsvWithHeaderMapper.class)
    public void test(int a1,int a2, int expected){
        calc.add(a1);
        calc.add(a2);
        assertEquals(expected, calc.getResult());
    }

}
