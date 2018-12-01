package containers;

import net.mindview.util.CollectionData;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;

import java.util.HashMap;
import java.util.HashSet;

class TwoString2 implements Comparable<TwoString2>{
    String s1, s2;

    public TwoString2(String s1i, String s2i) {
        s1 = s1i;
        s2 = s2i;
    }

    @Override
    public String toString() {
        return "[s1 = " + s1 + ", s2 = " + s2 + "]";
    }

    @Override
    public int compareTo(TwoString2 rv) {
        String rvi = rv.s1;
        return s1.compareTo(rvi);
    }

    @Override
    public int hashCode() {
        // Since the comparisons are based on s1, use s1's hashCode:
        return s1.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TwoString2 && ((TwoString2)obj).s1.equals(s1);
    }
    private static RandomGenerator.String gen = new RandomGenerator.String();
    public static Generator<TwoString2> generator(){
        return new Generator<TwoString2>() {
            @Override
            public TwoString2 next() {
                return new TwoString2(gen.next(), gen.next());
            }
        };
    }
}
public class E41_HashedComparable {
    public static void main(String[] args) {
        HashSet<TwoString2> hs = new HashSet<>();
        HashMap<TwoString2,Integer> hm = new HashMap<>();
        Generator<TwoString2> gen = TwoString2.generator();
        hs.addAll(CollectionData.list(gen, 20));
        for (int i = 0; i < 20; i++)
            hm.put(gen.next(), i);
        System.out.println("hs = " + hs);
        System.out.println("hm = " + hm);
    }
}
