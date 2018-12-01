package initialization.book;

import static net.mindview.util.Print.print;

// Explicit static initialization with the "static" clause.
class Cup {
    Cup(int marker){
        print("Cup(" + marker + ")");
    }
    void f(int marker){
        print("f(" + marker + ")");
    }
}
class Cups{
    static Cup cup1;
    static Cup cup2;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    Cups(){
        print("Cups()");
    }
}
public class ExplicitStatic {
    public static void  main(String[] args){
        print("Inside main()");
        //Cups.cup1.f(99); // (1)
    }
        static Cups cups1 = new Cups();  // (2)
        static Cups cups2 = new Cups();  // (2)
}
