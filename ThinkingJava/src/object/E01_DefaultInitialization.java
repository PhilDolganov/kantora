package object;

public class E01_DefaultInitialization {
    int x;
    char a;

    public E01_DefaultInitialization(){
        System.out.println("x = "+x);
        System.out.println("a = [" + a + ']');
    }
    public static void main (String[] args){
        new E01_DefaultInitialization();
    }
}
