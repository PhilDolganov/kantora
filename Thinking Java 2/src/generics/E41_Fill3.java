package generics;

import typeinfo.pets.Cymric;
import typeinfo.pets.Mouse;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.print;

public class E41_Fill3 {
    public static void main(String[] args) throws Exception {
        // Adapt a collection
        List<Pet> carrier = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<Pet>(carrier), Pet.class, 3);
        // Helper method captures the type:
        Fill2.fill(Adapter.collectionAdapter(carrier), Mouse.class, 2);
        for (Pet p : carrier)
            print(p);
        print("---------------------");
        // Use an adapted class:
        AddableSimpleQueue<Pet> petQueue = new AddableSimpleQueue<>();
        Fill2.fill(petQueue, Mutt.class,4);
        Fill2.fill(petQueue, Cymric.class,1);
        for (Pet p : petQueue)
            print(p);
    }
}
