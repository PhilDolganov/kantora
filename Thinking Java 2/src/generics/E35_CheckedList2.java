package generics;

import generics.coffee.Americano;
import generics.coffee.Breve;
import generics.coffee.Coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E35_CheckedList2 {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyAmericanos){
        probablyAmericanos.add(new Breve());
    }

    public static void main(String[] args) {
        List<Americano> am1 = new ArrayList<>();
        oldStyleMethod(am1); // Quietly accepts a Breve
        List<Americano> am2 = Collections.checkedList(new ArrayList<>(), Americano.class);

        try {
            oldStyleMethod(am2);
        } catch (Exception e) {
            System.out.println(e);
        }
        // Derived types work fine:
        List<Coffee> coffees = Collections.checkedList(new ArrayList<>(), Coffee.class);
        coffees.add(new Americano());
        coffees.add(new Breve());
    }
}
