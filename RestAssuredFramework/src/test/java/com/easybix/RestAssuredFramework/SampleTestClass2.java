package com.easybix.RestAssuredFramework;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class SampleTestClass2 {

    private static Logger log = LogManager.getLogger(SampleTestClass2.class.getName());

    @Test
    public void thirdTest() {
        System.out.printf("My Third Test");
    }

    @Test
    public void fourthTest() {
        System.out.printf("My Fourth Test");
    }

    @Test
    public void fifthTest() {
        int i = 1;
        try {
            int j = i / 0;
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test(retryAnalyzer = Retry.class)
    public void sixthTest() {
        int i = 1;
        int j = i / 0;

    }
}