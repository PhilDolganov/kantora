package object;

public class E08_StaticTest {
    static int i = 47;
    public static void main (String[] args){
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();
        System.out.println(st1.i + " == " + st2.i);
        st1.i++;
        System.out.println(st1.i + " == " +st2.i);

    }
}
