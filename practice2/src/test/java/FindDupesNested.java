public class FindDupesNested {
    public void printRepeating(int arr[], int size){
        int i, j;
        for (i = 0; i < size; i++){
            for (j = i+1; j< size; j++){
                if (arr[i] == arr[j])
                    System.out.print(arr[i] + ",");
            }
        }
    }
    public static void main(String[] args){
        FindDupesNested repeat = new FindDupesNested();
        int arr[] = {2,2,3,4,5,5,7,7,5,4,3,11,22};
        int arr_size = arr.length;
        repeat.printRepeating(arr, arr_size);

    }
}
