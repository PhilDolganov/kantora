package oops.java;

public class OvverideClassTwo extends OverrideClassOne {

    public void getMethod(){
        System.out.println("Hi, I'm getMethod() from child class");
    }

    public void calculateArea(int len, int width){
        int area = len * width;
    }
    public static void main(String[] args){
        OvverideClassTwo child = new OvverideClassTwo();
        child.getMethod();
        child.calculateArea(10,10);
        child.display();
    }
}
