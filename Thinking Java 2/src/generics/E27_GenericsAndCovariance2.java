package generics;

import java.util.ArrayList;
import java.util.List;

public class E27_GenericsAndCovariance2 {
    public static void main(String[] args){
        // Cmpile Error: incompatible types:
        // List<Number> nlist = new ArrayList<Integer>();
        // Wildcards allow covariance:
        List<? extends Number> nList = new ArrayList<Integer>();
        // Compile Error: can't add any type of object:
        // nList.add(new Integer(1));
        // nList.add(new Float(1.0));
        // nList.add(new Object());
        nList.add(null); // Legal but uninteresting
        // We know that it returns at least Number:
        Number n = nList.get(0);
    }
}
