package testng;

import org.testng.annotations.Test;

public class ReportNGTest2 {

    @Test
    public void firstTest2(){
        long id = Thread.currentThread().getId();
        System.out.println("First Test from ReportNG Second" + id);
    }

    @Test
    public void seconTest2(){
        long id = Thread.currentThread().getId();
        System.out.println("Second Test from ReportNG Second" + id);
    }
}
