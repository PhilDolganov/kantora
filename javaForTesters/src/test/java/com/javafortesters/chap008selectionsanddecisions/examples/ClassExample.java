package com.javafortesters.chap008selectionsanddecisions.examples;

import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ClassExample {

    @Test
    public void moreTernary(){
        String url = "www.eviltester.com";

        url = url.startsWith("http") ? url : addHttp(url);

        assertTrue(url.startsWith("http://"));
        assertEquals("http://www.eviltester.com", url);
    }

    private String addHttp(String url){
        return "http://" + url;
    }

    @Test
    public void catOrCats(){
        int numberOfCats = 1;

        assertEquals("1 == cat", "cat", (numberOfCats==1) ? "cat" : "cats");

        numberOfCats = 0;
        assertEquals("0 == cats", "cats", (numberOfCats==1) ? "cat" : "cats");

        numberOfCats = 2;
        assertEquals("2 == cats", "cats", (numberOfCats == 1)? "cat" : "cats");
    }

    @Test
    public void catOrCatsAsMethod(){
        assertEquals("1 == cat", "cat", catOrCats(1));
        assertEquals("0 == cats", "cats", catOrCats(0));
        assertEquals("2 == cats", "cats", catOrCats(2));
    }
    private String catOrCats(int numberOfCats){
        return (numberOfCats == 1) ? "cat" : "cats";
    }

    @Test
    public void ifAddHttp(){
        String url = "www.seleniumsimplified.com";
        if (!url.startsWith("http")){
            url = addHttp(url);
        }
        assertTrue(url.startsWith("http://"));
        assertEquals("http://www.seleniumsimplified.com", url);
    }

    @Test
    public void truthyIf(){
        boolean truthy = true;
        if (truthy)
            assertTrue(truthy);

        if (truthy){
            assertTrue(truthy);
            assertFalse(!truthy);
        }
    }

    @Test
    public void ifElseAddHttp(){
        String url = "www.seleniumsimplified.com";
        if (url.startsWith("http")){
            // do nothing the url is fine
        } else {
            url = addHttp(url);
        }
        assertTrue(url.startsWith("http://"));
        assertEquals("http://www.seleniumsimplified.com", url);
    }

    @Test
    public void truthyIfElse(){
        boolean truthy = true;
        if (truthy)
            assertTrue(truthy);
        else
            assertFalse(truthy);
    }

    @Test
    public void truthyIfElseBraces(){
        boolean truthy = true;
        if(truthy){
            assertTrue(truthy);
            assertFalse(!truthy);
        } else {
            assertFalse(truthy);
        }
    }

    @Test
    public void ifElseNestedAddHttp(){
        String url = "seleniumsimplified.com";
        if (url.startsWith("http")){
            // do nothing the url is fine
        } else {
            if (!url.startsWith("www")){
                url = "www." + url;
            }
            url = addHttp(url);
        }
        assertTrue(url.startsWith("http://"));
        assertEquals("http://www.seleniumsimplified.com", url);
    }

    @Test
    public void nestedIfElseHorror(){
       horrorOfNestedIfElse(true, true);
       horrorOfNestedIfElse(true, false);
       horrorOfNestedIfElse(false, true);
       horrorOfNestedIfElse(false, false);
    }

    public void horrorOfNestedIfElse(boolean truthy, boolean falsey){
        if (truthy){
            if (!falsey){
                if (truthy && !falsey){
                    if (falsey || truthy){
                        System.out.println("T | F");
                        assertTrue(truthy);
                        assertFalse(falsey);
                    }
                }
            } else {
                System.out.println("T | T");
                assertTrue(truthy);
                assertTrue(falsey);
            }
        } else {
            if (!truthy){
                if (falsey){
                    System.out.println("F | T");
                    assertTrue(falsey);
                    assertFalse(truthy);
                } else {
                    System.out.println("F | F");
                    assertFalse(falsey);
                    assertFalse(truthy);
                }
            }
        }
    }

    @Test
    public void switchExample(){
        assertEquals("M", likelyGenderIs("sir"));
        assertEquals("M", likelyGenderIs("mr"));
        assertEquals("M", likelyGenderIs("master"));
        assertEquals("F", likelyGenderIs("miss"));
        assertEquals("F", likelyGenderIs("mrs"));
        assertEquals("F", likelyGenderIs("ms"));
        assertEquals("F", likelyGenderIs("lady"));
        assertEquals("F", likelyGenderIs("madam"));
    }
    public String likelyGenderIs(String title){
        String likelyGender;

        switch (title.toLowerCase()){
            case "sir": likelyGender = "M";
                break;
            case "mr": likelyGender = "M";
                break;
            case "master": likelyGender = "M";
                break;
            default: likelyGender = "F";
                break;
        }
        return likelyGender;
    }

    @Test
    public void countrySwitch(){
        assertEquals("United Kingdom", countryOf("UK"));
        assertEquals("United States", countryOf("US"));
        assertEquals("United States", countryOf("USA"));
        assertEquals("United States", countryOf("UsA"));
        assertEquals("France", countryOf("FR"));
        assertEquals("Sweden", countryOf("SE"));
        assertEquals("Rest Of World", countryOf("ES"));
        assertEquals("Rest Of World", countryOf("CH"));
    }

    private String countryOf(String shortCode){

        String country;

        switch (shortCode.toUpperCase()){
            case "UK" : country = "United Kingdom";
            break;
            case "US" :
            case "USA": country = "United States";
            break;
            case "FR": country = "France";
            break;
            case "SE": country = "Sweden";
            break;
            default: country = "Rest Of World";
            break;
        }
        return country;
    }

    @Test
    public void integerSwitch(){
        assertEquals("One", integerString(1));
        assertEquals("Two", integerString(2));
        assertEquals("Three", integerString(3));
        assertEquals("Four", integerString(4));
        assertEquals("Too big", integerString(5));
        assertEquals("Too big", integerString(Integer.MAX_VALUE));
        assertEquals("Too small", integerString(0));
        assertEquals("Too small", integerString(Integer.MIN_VALUE));
    }

    private String integerString(int anInt){

        String valReturn ="";

        switch (anInt){
            case 1: valReturn = "One";
            break;
            case 2: valReturn = "Two";
            break;
            case 3: valReturn = "Three";
            break;
            case 4: valReturn = "Four";
            break;
            default:
                if (anInt < 1){
                    valReturn = "Too small";
                }
                if (anInt > 4){
                    valReturn = "Too big";
                }
            break;
        }
        return valReturn;
    }

    @Test
    public void returnOnlySwitch(){
        assertEquals("One", integerString(1));
        assertEquals("Two", integerString(2));
        assertEquals("Three", integerString(3));
        assertEquals("Four", integerString(4));
        assertEquals("Too big", integerString(5));
        assertEquals("Too big", integerString(Integer.MAX_VALUE));
        assertEquals("Too small", integerString(0));
        assertEquals("Too small", integerString(Integer.MIN_VALUE));
    }

    private String integerStringUsingReturnOnly(int anInt){
        switch (anInt){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            default:
                if (anInt < 1){
                    return "Too small";
                }
        }
        return "Too big";
    }
}
