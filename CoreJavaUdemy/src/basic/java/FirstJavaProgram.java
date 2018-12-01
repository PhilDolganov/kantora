package basic.java;

public class FirstJavaProgram {

    public void firstMethod(){
        System.out.println("Hello! This is my First Program");
    }

    public void secondMethod(){
        System.out.println("Hi, I am Udemy Java for Testers");
    }
    public static void main(String[] args){
        FirstJavaProgram firstProg = new FirstJavaProgram();
        firstProg.firstMethod();
        firstProg.secondMethod();
        System.out.println(VariableClass.k);
    }
}
