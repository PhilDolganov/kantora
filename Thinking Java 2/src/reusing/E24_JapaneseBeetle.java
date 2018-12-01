package reusing;

import static net.mindview.util.Print.print;

class JapaneseBeetle extends Beetle {
    int m = printInit("JapaneseBeetle.m initialized");
    JapaneseBeetle(){
        print("m = " + m);
        print("j = " + j);
    }
    static int x3 = printInit("static JapaneseBeetle.x3 initialized");
}
public class E24_JapaneseBeetle {
    public static void main(String[] args){
        new JapaneseBeetle();

    }
}
