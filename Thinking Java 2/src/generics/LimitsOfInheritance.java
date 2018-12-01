package generics;
import typeinfo.pets.*;

import java.util.List;
import java.util.Map;

public class LimitsOfInheritance {
    static void f(Map<Person, List<? extends Pet>> petPeople){}
    public static void main(String[] args){
        // f(New.map()); // Doesn't compile
    }
}
