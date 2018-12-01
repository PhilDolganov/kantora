package holding;

import java.util.*;

public class E11_IterToString {
    public static void printToStrings(Iterator<?> it){
        while (it.hasNext())
            System.out.println(it.next().toString());
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        List<Collection<String>> ca = Arrays.<Collection<String>>asList(
                new ArrayList<String>(),
                new LinkedList<String>(),
                new HashSet<String>(),
                new TreeSet<String>());
        for (Collection<String> c : ca)
            printToStrings(c.iterator());
    }
}
