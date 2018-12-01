package polymorphism;

import static net.mindview.util.Print.print;

class Pickle{
    Pickle(){print("Pickle()");}
}
class Sandwich2 extends PortableLunch {
    Bread b = new Bread();
    Cheese c = new Cheese();
    Lettuce l = new Lettuce();
    Pickle p = new Pickle();
    Sandwich2(){print("Sandwich()");}
}
public class E11_Pickle {
    public static void main (String[] args){
        new Sandwich2();
    }
}
