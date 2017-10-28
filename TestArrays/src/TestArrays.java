import java.util.Arrays;

public class TestArrays {
    public static void main (String[] args){
 //       int array[]; C++ implementation
        int[] array; //declare array in java
//        String strings[];
        String[] str;

        array = new int[55];
        str = new String[21];

        str[0] = new String("Vlad");
        str[1] = "Tony";

        for (int i = 0; i < str.length; i++)
            System.out.println(str[i]);

        String[] family = {"mama", "papa"};

        String[] books = {"War and Peace", "Farewell to Arms", "Hamlet"};
        String[] books2 = {"War and Peace", "Farewell to Arms", "Hamlet"};

        if (books == books2)//reference variables are not equal
            System.out.println("Equals");

        if (Arrays.equals(books, books2));//correct way to compare arrays
            System.out.println("Equals now");
    }
}
