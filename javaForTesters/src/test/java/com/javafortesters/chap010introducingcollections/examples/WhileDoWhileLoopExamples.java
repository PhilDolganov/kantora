package com.javafortesters.chap010introducingcollections.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WhileDoWhileLoopExamples {

    String[] someDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    List<String> days = Arrays.asList(someDays);

    @Test
    public void forEachLoop(){
        int forCount = 0;
        for (String day : days) {
            if (day.equals("Monday")){
                break;
            }
            forCount++;
        }
        assertEquals("Monday is at position 0", 0, forCount);
    }

    @Test
    public void forLoop(){
        int loopCount;
        for (loopCount = 0; loopCount <= days.size(); loopCount++) {
            if (days.get(loopCount).equals("Monday")) {
                break;
            }
        }
            assertEquals("Monday is at position 0",0,loopCount);

    }

    @Test
    public void whileLoop(){
        int count = 0;
        while (!days.get(count).equals("Monday")){
            count++;
        }
        assertEquals("Monday is at position 0", 0, count);
    }

    @Test
    public void doWhileLoop(){
        int docount =-1;
        do {
            docount++;
        } while (!days.get(docount).equals("Monday"));
        assertEquals("Monday is at position 0", 0, docount);
    }

    @Test
    public void forLoopInsteadOfWhile(){
        String[] someDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        List<String> days = Arrays.asList(someDays);
        int forwhile;
        for (forwhile = 0; !days.get(forwhile).equals("Friday"); forwhile++){
        }
        assertEquals("Friday is at position 4",4, forwhile);
    }
}
