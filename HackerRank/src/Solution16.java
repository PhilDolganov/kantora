import java.util.Scanner;

public class Solution16 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        try {
            int output = Integer.parseInt(s);
            System.out.println(output);
        } catch (NumberFormatException e){
            System.out.println("Bad String");
        }
        in.close();
    }
}
