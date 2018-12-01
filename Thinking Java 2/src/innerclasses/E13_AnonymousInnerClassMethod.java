package innerclasses;

import innerclasses.exercise6.SimpleInterface;

public class E13_AnonymousInnerClassMethod {
    public SimpleInterface get() {
        return new SimpleInterface() {
            public void f() {
                System.out.println("SimpleInterface.f");
            }
        };
    }
    public static void main(String[] args){
        SimpleInterface si = new E13_AnonymousInnerClassMethod().get();
        si.f();
    }
}
