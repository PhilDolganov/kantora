package generics;

import java.util.Iterator;

class IterableFibonaccii implements Iterable<Integer> {
    private Fibonacci fib = new Fibonacci();
    private int n;
    public IterableFibonaccii(int count){n=count;}

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                --n;
                return fib.next();
            }

            @Override
            public void remove() {
                // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
}
public class E07_IterableFibonacci2 {
    public static void main(String[] args){
        for (int i : new IterableFibonacci(18))
            System.out.print(i + " ");
    }
}
