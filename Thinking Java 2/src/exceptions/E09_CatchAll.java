package exceptions;

class ExBase extends Exception {}
class Ex1 extends ExBase {}
class Ex2 extends ExBase {}
class Ex3 extends ExBase {}

class Thrower2 {
    void f() throws Ex1, Ex2, Ex3 {
        throw new Ex1();
        // You aren't forced to throw all the
        // exceptions in the specification.
    }
}
public class E09_CatchAll {
    public static void main(String[] args){
        Thrower2 t = new Thrower2();
        try {
            t.f();
        } catch (ExBase e) {
            System.out.println("caught " + e);
        } catch (Exception e) {
            System.out.println("caught " + e);
        }
    }
}
