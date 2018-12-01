package oops.java;

public class SampleClass3 extends SampleClass2 {

    public void methodThree(){
        System.out.println("Hi, I am class 3 and Method 1");
    }
    public static void main(String[] args){
        SampleClass3 sc3 = new SampleClass3();
        sc3.method1();
        sc3.methodOne();
    }
}
