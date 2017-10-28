public class TestStrings {
    public static void main (String[] args){
        String name = new String("Tony");
        String name2 = "Vlad";

        System.out.println("Hello, " + name2);
        // charAt(int position)
        name2.charAt(1);

        String palendrome = new String("Madam I'm Adam");
        System.out.println(palendrome.substring(2, 5));

        palendrome.split(" ");//array of 3 strings

        // indexOf(char ch)
        palendrome.indexOf('I');
        System.out.println(palendrome.length());

        String pal = new String("Madam I'm Adam");

        if (palendrome.equals(pal)) // comparing content of the string, not reference variable
            System.out.println("Strings are equal");
        else
            System.out.println("Strings are not equal");

        String movieStar = "Tom Cruse";
        char first = movieStar.charAt(0);
        int space = movieStar.indexOf(' '); // because it is char space - single quotes must be used
        char last = movieStar.charAt(space + 1);

        System.out.println(""+first + last); // returns sum of ASCII table indexes. T = 84 & C = 64; Add empty string by inserting pair of double quotes

        String str = "I like learning java";//print backwards
        for (int i = 0; i < str.length(); i++)
            System.out.println(str.charAt(str.length() - 1 - i));

        System.out.println("");
        for (int i = str.length() -1; i >=0; i--)
            System.out.print(str.charAt(i));

        System.out.println("");
        String[] words = str.split(" ");
        for (int i = words.length - 1; i >=0; i-- )
            System.out.print(words[i] + " ");

        StringBuilder sb = new StringBuilder(str);
        System.out.println("\n"+sb.reverse());
    }
}
