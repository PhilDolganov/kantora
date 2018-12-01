public class BinarySearch {

    static int[] numbers = {2,6,9,13,17,19,32,38,45,98,111,156,187};

    // This is iterative Approach of Binary Search, Complexity O(1)
    private static int bSearchIteration(int[] arr, int value){
        int length = arr.length - 1, start = 0;

        while (start<=length){
            int mid = start + (length-start)/2;

            if (arr[mid]==value){
                return mid;
            }else if (value < arr[mid]){
                length = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // This is recursive Approach of Binary Search, Complexity is O (logn)
    private static int bSearchRecursion(int[] arr, int start, int length, int value){

        if (length>=start){
            int mid = start + (length-start)/2;

            if (value==arr[mid]){
                return mid;
            } else if (value < arr[mid]){
                return bSearchRecursion(arr,start,mid-1,value);
            } else {
                return bSearchRecursion(arr,mid+1, length,value);
            }
        }
        return -1;
    }

    public static void main(String[] args){

        BinarySearch bsr = new BinarySearch();
        int index = bSearchIteration(numbers,111);
        System.out.println("Index is: " + index);
    }
}
