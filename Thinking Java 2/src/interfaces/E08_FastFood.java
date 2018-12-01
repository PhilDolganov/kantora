package interfaces;
import polymorphism.book.Sandwich;

import static net.mindview.util.Print.print;

interface FastFood {
    void rushOrder();
    void gobble();
}
class FastSandwich extends Sandwich implements FastFood {
    public void rushOrder() {
        print("Rushing your sandwich order");
    }
    public void gobble() {print("Chomp! Snort! Gobble!"); }
}

public class E08_FastFood {
    public static void main (String[] args){
        FastSandwich burger = new FastSandwich();
        print("Fries with that?");
        print("Super Size?");
        burger.rushOrder();
        burger.gobble();
    }
}
