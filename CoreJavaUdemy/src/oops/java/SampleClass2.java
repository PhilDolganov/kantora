package oops.java;

public class SampleClass2 extends SampleClass {
    public void methodOne(){
        System.out.println("Hi, I'm Class 2 and Method 1");
    }

    public static void main(String[] args){
        SampleClass2 sc2 = new SampleClass2();
        sc2.methodOne();
        sc2.method2();
    }
}
