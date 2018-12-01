package oops.java;

public class AbsClassTwo extends AbsClassOne {

    @Override
    public void displayMethod() {
        System.out.println("Hi, I'm from Concrete Class Method 1");
    }

    @Override
    public void spinMethod() {
        System.out.println("Hi, I'm from Concrete Class Method 2");
    }

    public static void main(String[] args){
        AbsClassTwo abs = new AbsClassTwo();
        abs.displayMethod();
        abs.spinMethod();
    }

    @Override
    public void methodThree() {

    }
}
