import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoveDuplicatesFromArray {
//    private static final Logger logger = LoggerFactory.getLogger(RemoveDuplicatesFromArray.class);
//    public static void main(String[] args){
//        int[][] test = new int[][]{
//                {1,1,2,2,3,4,5},
//                {1,1,1,1,1,1,1},
//                {1,2,3,4,5,6,7},
//                {1,2,1,1,1,1,1},};
//        for (int[] input : test){
////            System.out.println("Array with Duplicates       : " + Arrays.toString(input));
////            System.out.println("After removing Duplicates   : " + Arrays.toString(removeDuplicates(input)));
//        }
//    }
//    public static int[] removeDuplicates(int[] numbersWithDuplicates){
//        // Sorting array to bring duplicates together
////        Arrays.sort(numbersWithDuplicates);
//        int[] result = new int[numbersWithDuplicates.length];
//        int previous = numbersWithDuplicates[0];
//        result[0] = previous;
//        for (int i = 1; i < numbersWithDuplicates.length; i++){
//            int ch = numbersWithDuplicates[i];
//            if (previous != ch){
//                result[i] = ch;
//            }
//            previous = ch;
//        }
//        return result;
//    }
    public static void main(String[] args){
        int[] num = {25,52,25,65,8,96,8,25};
        String s = "";
        for (int i = 0; i < num.length; i++){
            if (!s.contains(String.valueOf(num[i])))
                s+=num[i]+",";
        }
        String stringArray[] = s.split(",");
        int[] uniqnum = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++)
            uniqnum[i] = Integer.parseInt(stringArray[i]);
        for (int i = 0; i < uniqnum.length; i++){
            System.out.print(uniqnum[i] + " ");
        }
    }
}
