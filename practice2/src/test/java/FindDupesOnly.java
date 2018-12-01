import java.util.ArrayList;
import java.util.HashMap;

public class FindDupesOnly {
    public static void findDuplicates(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++){
            if (!map.containsKey(arr[i]))
                map.put(arr[i], 1);
             else
                map.put(arr[i], map.get(arr[i])+ 1);
        }
        ArrayList<Integer> dupes = new ArrayList<Integer>();
            for (Integer i : map.keySet())
                if (map.get(i)> 1)
                    dupes.add(i);
            System.out.print(dupes + ",");

    }
    public static void main(String[] args){
        int arr[] = {1,2,3,4,2,1,2,3,4,5,6,7,8,22,34,1,666,666,5,28};
        findDuplicates(arr);
    }

}

