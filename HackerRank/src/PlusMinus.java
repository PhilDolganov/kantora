import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {

    static void plusMinus(int[] arr){
        int positive = 0;
        int negative = 0;
        int zero = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                positive++;

            } else if (arr[i] == 0) {
                zero++;
            }else {
                negative++;
            }
        }
        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.println(df.format((double) positive / arr.length));
        System.out.println(df.format((double) negative / arr.length));
        System.out.println(df.format((double) zero / arr.length));

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}




