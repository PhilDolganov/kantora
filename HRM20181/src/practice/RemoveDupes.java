package practice;

public class RemoveDupes {
   public static void removeDuplicates(int[] arr, int size){
       int i,j;
       for (i = 0; i < size; i++){
           for (j = i+1; j < size; j++){
               if (arr[i] == arr[j])
                   System.out.print(arr[i] + ",");
           }
       }
   }
   public static void main(String[] args){
       int[] arr = {1,2,3,4,4,5,3,2};
       int size = arr.length;
       removeDuplicates(arr,size);
   }
}
