package object;

class StaticTest {
    static int i = 47;
}
public class E_07_Incrementable {
    static void increment(){
        StaticTest.i++;
    }
    public static void main(String[] args){
        E_07_Incrementable sf = new E_07_Incrementable();
        sf.increment();
        E_07_Incrementable.increment();
    }
}
