package typeinfo;
// The difference between instanceof and class

import static net.mindview.util.Print.print;

class Base1 {}
class Derived1 extends Base1 {}

public class FamilyVsExactType {
    static void test(Object x){
        print("Testing x of type " + x.getClass());
        print("x instanceof Base1 " + (x instanceof Base1));
        print("x instanceof Derived1 " + (x instanceof Derived1));
        print("Base1.isInstance(x) " + Base1.class.isInstance(x));
        print("Derived1.isInstance(x) " + Derived1.class.isInstance(x));
        print("x.getClass() == Base1.class " + (x.getClass() == Base1.class));
        print("x.getClass() == Derived1.class " + (x.getClass() == Derived1.class));
        print("x.getClass().equals(Base1.class)) " + (x.getClass().equals(Base1.class)));
        print("x.getClass().equals(Derived1.class)) " + (x.getClass().equals(Derived1.class)));
    }
    public static void main(String[] args){
        test(new Base1());
        test((new Derived1()));
    }
}
