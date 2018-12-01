package reusing;

class A {
    public A() {System.out.println("A()");}
}
class B {
    public B() {System.out.println("B()");}
}
class C extends A {
    B b = new B();
}
public class E05_SimpleInheritance {
    public static void main(String[] args){
        new C();
    }
}
