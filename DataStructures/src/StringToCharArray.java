import java.util.Arrays;

public class StringToCharArray {
    public static void main (String[] args){
        String sentence = "I like learning.";
        char[] charArray = sentence.toCharArray();
        Arrays.sort(charArray);
        System.out.println(charArray);
    }
}
