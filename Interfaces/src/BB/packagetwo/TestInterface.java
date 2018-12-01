package BB.packagetwo;

public class TestInterface {
    public static void main (String[] args){
        Hello hello = new Hello();
        hello.sayGreeting();
        Hi hi = new Hi();

        Greetings g = hello;
        g.sayGreeting();
        g = hi;
        g.sayGreeting();
    }
}
