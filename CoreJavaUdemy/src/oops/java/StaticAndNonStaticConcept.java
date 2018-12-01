package oops.java;

public class StaticAndNonStaticConcept {

    // The scope of variables will be available across all functions

    String name = "Tom"; // non static global variable
    static int age = 25; // static global variable

    public static void main(String[] args){
        // how to call static methods and variables
        // 1. direct calling:
        sum();
        // 2. calling by classname
        StaticAndNonStaticConcept.sum();

        System.out.println(age);
        System.out.println(StaticAndNonStaticConcept.age);

        // How to call non-static methods and objects
        StaticAndNonStaticConcept obj = new StaticAndNonStaticConcept();
        obj.sendMail();
        System.out.println(obj.name);
        obj.sum();
    }

    public void sendMail(){ // non static method
        System.out.println("Send mail method");
    }
    public static void sum(){ // static method
        System.out.println("Sum method");
    }
}
