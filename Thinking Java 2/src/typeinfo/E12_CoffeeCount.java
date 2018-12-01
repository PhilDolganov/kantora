package typeinfo;

import net.mindview.util.TypeCounter;
import typeinfo.coffee2.Coffee;

import java.util.Iterator;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public class E12_CoffeeCount {
    public static void main(String[] args){
        TypeCounter counter = new TypeCounter(Coffee.class);
        for (Iterator<Coffee> it = new E16_CoffeeGenerator(20).iterator(); it.hasNext();){
            Coffee coffee = it.next();
            printnb(coffee.getClass().getSimpleName() + " ");
            counter.count(coffee);
        }
        print();
        print(counter);
    }
}
