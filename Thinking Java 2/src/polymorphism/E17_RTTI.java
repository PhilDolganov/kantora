package polymorphism;

import polymorphism.cycle.Bicycle;
import polymorphism.cycle.Cycle;
import polymorphism.cycle.Tricycle;
import polymorphism.cycle.Unicycle;

public class E17_RTTI {
    public static void main(String[] args) {
        Cycle[] cycles = new Cycle[]{new Unicycle(),
                new Bicycle(), new Tricycle()};
        // Compile time: method not found in Cycle:
        // cycles[0].balance();
        // cycles[1].balance();
        // cycles[2].balance();
//        ((Unicycle)cycles[0]).balance(); // Downcast/RTTI
//        ((Unicycle)cycles[1]).balance(); // Downcast/RTTI
//        ((Unicycle)cycles[2]).balance(); // Exception thrown
//    }
//}
//public class Unicycle extends Cycle {
//    public void balance() {}
//}
//public class Bicycle extends Cycle {
//    public void balance() {}
    }
}