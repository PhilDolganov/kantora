package strings;

public class E09_Replacing2 {
    public static void main(String[] args){
        System.out.println(Splitting.knights.replaceAll("(?i)[aeiou]","_"));
    }
}
