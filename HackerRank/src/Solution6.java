import java.util.Scanner;

public class Solution6 {
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++){
            char[] inputString = scan.next().toCharArray();

            // Print even characters
            for (int j = 0; j < inputString.length; j+=2){
                System.out.print(inputString[j]);
            }
            System.out.print(" ");

            // Print odd characters
            for (int j = 1; j < inputString.length; j+=2){
                System.out.print(inputString[j]);
            }
            System.out.println();
        }
        scan.close();
    }
}
