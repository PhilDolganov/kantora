package testng;

import org.testng.annotations.Test;

public class SamplePriorityTest {

    @Test(groups = {"smoke","regression"})
    public void firstTest(){
        long id = Thread.currentThread().getId();
        System.out.println("First test " + id);
    }

    @Test(priority = 1, groups = "sanity")
    public void secondTest(){
        long id = Thread.currentThread().getId();
        System.out.println("Second test " + id);
    }

    @Test(priority = 2, groups = "sanity")
    public void thirdTest(){
        long id = Thread.currentThread().getId();
        System.out.println("Third test " + id);
    }

    @Test(priority = 3, groups = "smoke")
    public void forthTest(){
        long id = Thread.currentThread().getId();
        System.out.println("Fourth test " + id);
    }

    @Test(priority = 4, groups = {"functional", "regression"})
    public void fifthTest(){
        long id = Thread.currentThread().getId();
        System.out.println("Fifth test " + id);
    }
}
