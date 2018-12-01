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
    @FileParameters(value = "file:C:/Users/phild_000/IdeaProjects/addsub.csv", mapper = CsvWithHeaderMapper.class)
    public void test(int op1, String sign, int op2, int expected){
        calc.add(op1);
        switch (sign){
            case "+":
                calc.add(op2);
                break;
            case "-":
                calc.subtract(op2);
                break;
        }
        assertEquals(expected, calc.getResult());
    }
}
