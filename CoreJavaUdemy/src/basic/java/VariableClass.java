package basic.java;

public class VariableClass {
    // Instance Variable
    int j = 200;

    static int k = 300;

    public void firstMethod(){
        // Local Variable
        int i = 100;
        System.out.println(i);
        System.out.println(j);
    }

    public void secondMethod(){
        System.out.println(j);
    }
    public static void main(String[] args){
        VariableClass vClass = new VariableClass();
//        vClass.firstMethod();
//        vClass.secondMethod();

        System.out.println(vClass.j);
        System.out.println(k);

        AccessModifiers am = new AccessModifiers();
        System.out.println(am.k);
        am.secondMethod();
    }
}
