package com.javafortesters.chap020mathandbigdecimal.examples;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Class20Examples {

    @Test
    public void bigDecimal() {
        BigDecimal bdtotal = new BigDecimal("0.1").add(new BigDecimal("0.73"));
        assertThat(bdtotal, is(new BigDecimal("0.83")));
    }

    @Test
    public void convinceYourselfOfBigDecimalUsage() {
        try {
            double total = 5 - 0.3 - 0.47 - 1.73;
            System.out.println("2.5 != " + total);
            assertThat(total, is(2.5));
            fail("Expected the assert to fail");
        } catch (java.lang.AssertionError e) {
        }

        int inPennies = 500 - 30 - 47 - 173;
        assertThat(inPennies, is(250));

        BigDecimal bdtotal = new BigDecimal("5").
                subtract(new BigDecimal("0.30")).
                subtract(new BigDecimal("0.47")).
                subtract(new BigDecimal("1.73"));
        assertThat(bdtotal, is(new BigDecimal("2.50")));
    }

    @Test
    public void constructBigDecimal(){
        BigDecimal fromInt = new BigDecimal(5);
        BigDecimal fromLong = new BigDecimal(5L);
        BigDecimal fromString = new BigDecimal("5");
        BigDecimal frmDouble = new BigDecimal(5.0);
        BigDecimal fromBigInteger = new BigDecimal(BigInteger.valueOf(5L));

        BigDecimal bd0 = BigDecimal.ZERO;
        BigDecimal bd1 = BigDecimal.ONE;
        BigDecimal bd10 = BigDecimal.TEN;
        BigDecimal bdVal = BigDecimal.valueOf(5.0);
    }

    @Test
    public void basicArithmeticWithBigDecimal(){
        BigDecimal bd = BigDecimal.ZERO;
        bd = bd.add(BigDecimal.TEN);
        bd = bd.multiply(BigDecimal.valueOf(2L));
        bd = bd.subtract(BigDecimal.TEN);
        bd = bd.divide(BigDecimal.valueOf(2L));

        assertThat(bd, is(BigDecimal.valueOf(5L)));
    }

    @Test
    public void comparisonOperators(){
        assertThat(BigDecimal.ONE.equals(new BigDecimal(1.0)), is(true));
        assertThat(BigDecimal.ONE.equals(new BigDecimal("1")), is(true));
    }

    @Test
    public void compareTenAndOne(){
        assertTrue(BigDecimal.TEN.compareTo(BigDecimal.ONE) > 0);
        assertTrue(BigDecimal.ONE.compareTo(BigDecimal.TEN) < 0);
        assertTrue(BigDecimal.TEN.compareTo(BigDecimal.TEN) == 0);
        assertTrue(BigDecimal.TEN.compareTo(BigDecimal.ONE) != 0);
        assertTrue(BigDecimal.TEN.compareTo(BigDecimal.ONE) >= 0);
        assertTrue(BigDecimal.TEN.compareTo(BigDecimal.TEN) >= 0);
        assertTrue(BigDecimal.ONE.compareTo(BigDecimal.TEN) <= 0);
        assertTrue(BigDecimal.ONE.compareTo(BigDecimal.ONE) <= 0);
    }

    @Test
    public void math(){
        assertThat(Math.max(23.0, 42.0), is(42.0));

    }
}
