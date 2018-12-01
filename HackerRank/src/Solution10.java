import java.util.Scanner;

public class Solution10 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        // convert number->binary string->char array
        char[] binary = Integer.toBinaryString(n).toCharArray();
        int tempCount = 0; // counts consecutive ones
        int maxCount = 0;  // running maximum of consecutive ones
        for (int i = 0; i < binary.length; i++){
            // reset to 0 if we hit a '0' char
            tempCount = (binary[i] == '0') ? 0: tempCount +1;

            // set max
            if (tempCount > maxCount){
                maxCount = tempCount;
            }
        }
        System.out.println(maxCount);
    }
}
