package com.easybix.RestAssuredFramework;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;



public class SampleTestClass1 {

    protected   static Logger log = LogManager.getLogger(SampleTestClass1.class.getName());

    @Test
    public void firstTest(){
        log.debug("First Test Case");
    }

    @Test
    public void secondTest(){
        log.info("Second Test");
    }
}
