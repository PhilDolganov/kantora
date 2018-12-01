package containers;
//Java 1.0/1.1 Vector and Enumeration

import net.mindview.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class Enumerations {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>(Countries.names(10));
        Enumeration<String> e = v.elements();
        while (e.hasMoreElements())
            System.out.println(e.nextElement() + ", ");
        // Produce an Enumeration from Collection:
        e = Collections.enumeration(new ArrayList<>());
    }
}
