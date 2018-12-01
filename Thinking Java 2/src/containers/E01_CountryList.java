package containers;

import java.util.*;

import static net.mindview.util.Countries.names;
import static net.mindview.util.Print.print;

public class E01_CountryList {
    private static Random rand = new Random(47);
    public static void main(String[] args) {
        List<String> l = new LinkedList<>(names(8));
        Collections.sort(l);
        print("sorted: " + l);
        for (int i = 1; i < 5; i++) {
            Collections.shuffle(l, rand);
            print("shuffled (" + i + "): " + l);
        }
    }
}
