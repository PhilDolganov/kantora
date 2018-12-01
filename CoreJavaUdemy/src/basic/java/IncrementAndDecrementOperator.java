package basic.java;

public class IncrementAndDecrementOperator {

    public static void main(String[] args){
        // ++
        // --

        int i = 1;
        int j = i++; // Post increment

        System.out.println(i);
        System.out.println(j);

        int a = 1;
        int b = ++a; // Pre increment

        System.out.println(a);
        System.out.println(b);

        int m = 2;
        int n = m--; // Post decrement

        System.out.println(m);
        System.out.println(n);

        int p = 2;
        int q = --p; // Post decrement

        System.out.println(p);
        System.out.println(q);
    }
}
