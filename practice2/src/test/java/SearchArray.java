public class SearchArray {

    int[] numbers = {2,6,9,13,17,19,32,38,45,98,111,156,187};

    public void sort(int value){
        int index = 0;
        boolean flag = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]==value){
                index = i;
                flag = true;
                break;
            }
        }
        if (flag){
            System.out.println("Value is present at Index: " + index);
        } else {
            System.out.println("Value is not present in Array");
        }
    }

    public static void main(String[] args){
        SearchArray search = new SearchArray();
        search.sort(2);
    }
}
