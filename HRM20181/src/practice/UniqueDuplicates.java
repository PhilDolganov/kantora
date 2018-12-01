package practice;

import java.util.ArrayList;
import java.util.HashMap;

public class UniqueDuplicates {
    public static void removeUnique(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], 1);
               else map.put(arr[i], map.get(arr[i])+1);
        }
        ArrayList<Integer> dupes = new ArrayList<Integer>();
        for (Integer i : map.keySet())
            if (map.get(i)>1)
                dupes.add(i);
        System.out.print(dupes + ",");
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,5,4,2};
        removeUnique(arr);
    }
}
