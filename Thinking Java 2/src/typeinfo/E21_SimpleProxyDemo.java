package typeinfo;

import static net.mindview.util.Print.print;

interface Interface1 {
    void doSomething();
    void somethingElse(String arg);
}
class RealObject1 implements Interface1, Interface {
    @Override
    public void doSomething() {
    print("do something");
    }

    @Override
    public void somethingElse(String arg) {
        print("somethingElse " + arg);
    }
}
 class SimpleProxy1 implements Interface1, Interface {
    private Interface proxied;

    public SimpleProxy1(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        print("SimpleProxy doSomething");
        long start = System.nanoTime();
        proxied.doSomething();
        long duration = System.nanoTime() - start;
        print("METHOD-CALL TIME: " + duration);
    }

    @Override
    public void somethingElse(String arg) {
        print("SimpleProxy somethingElse " + arg);
        long start = System.nanoTime();
        proxied.somethingElse(arg);
        long duration = System.nanoTime() - start;
        print("METHOD-CALL TIME: " + duration);
    }
}
    public class E21_SimpleProxyDemo {
        public static void consumer(Interface iface) {
            iface.doSomething();
            iface.somethingElse("bonobo");
        }

        public static void main(String[] args) {
            consumer(new RealObject());
            consumer(new SimpleProxy1(new RealObject1()));
        }
    }






