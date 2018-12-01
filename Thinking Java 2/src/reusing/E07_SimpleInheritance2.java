package reusing;

class A2 {
    public A2(String s){ System.out.println("A2(): " + s);}
}
class B2 {
    public B2(String s){ System.out.println("B2(): " + s);}
}
class C2 extends A2 {
    B2 b;
    public C2(String s) {
        super(s);
        b = new B2(s);
    }
}
public class E07_SimpleInheritance2 {
    public static void main (String args[]){
        new C2("Init string");
    }
}
