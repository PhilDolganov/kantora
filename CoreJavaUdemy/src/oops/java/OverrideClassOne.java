package oops.java;

public class OverrideClassOne {
    public void getMethod(){
        System.out.println("Hi, I'm getMethod() from parent class");
    }

    public void calculateArea(int len, int width){
        int area = len * width;
    }

    public void display(){
        System.out.println("Display method from parent class");
    }
}
