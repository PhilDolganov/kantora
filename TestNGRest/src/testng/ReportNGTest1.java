package testng;

import org.testng.annotations.Test;

public class ReportNGTest1 {

    @Test
    public void firstTest1(){
        long id = Thread.currentThread().getId();
        System.out.println("First Test from ReportNG First" + id);
    }

    @Test
    public void secondTest1(){
        long id = Thread.currentThread().getId();
        System.out.println("Second Test from ReportNG First" + id);
    }
}
