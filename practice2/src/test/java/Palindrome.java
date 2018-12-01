public class Palindrome {
    public static void main(String[] args) {
        String palindrome = "Madam I'm Adam";
        for (int i = 0; i < palindrome.length(); i++)
            System.out.print(palindrome.charAt(palindrome.length() - 1 - i));



    }

}

