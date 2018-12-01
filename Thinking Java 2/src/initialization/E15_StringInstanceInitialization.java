package initialization;

public class E15_StringInstanceInitialization {
    String s;
    {s = "'instance initialization'";}
    public E15_StringInstanceInitialization(){
        System.out.println("Default constructor; s = " + s);
    }
    public E15_StringInstanceInitialization(int i){
        System.out.println("int constructor; s = " + s);
    }
    public static void main (String[] args){
        new E15_StringInstanceInitialization();
        new E15_StringInstanceInitialization(1);
    }
}
