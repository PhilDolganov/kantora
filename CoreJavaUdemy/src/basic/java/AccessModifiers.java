package basic.java;

public class AccessModifiers {

    private int i = 100;
    public int k = 200;
    private void firstMethod(){
        System.out.println("Value of i : " + i);
    }
    public void secondMethod(){
        System.out.println("Value of k : " + k);
    }

    public static void main(String[] args){
        AccessModifiers am = new AccessModifiers();
        am.firstMethod();
    }
}
