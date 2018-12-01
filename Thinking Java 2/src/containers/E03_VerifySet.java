package containers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static net.mindview.util.Countries.names;

public class E03_VerifySet {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < 5; i++)
            set.addAll(names(10));
        System.out.println(set);
    }
}
