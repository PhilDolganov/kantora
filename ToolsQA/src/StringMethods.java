public class StringMethods {
    public static void main(String[] args){
        // Declaring the string
        String sPopularTopic_1 = "Selenium automation Framework";
        String sPopularTopic_2 = "Basic Java Tutorial";

        // Compare 2 strings
        // If 2 strings are equal it will return 'true' else it will return 'false'
        boolean bCompareResult = sPopularTopic_1.equals(sPopularTopic_2);
        System.out.println("The result of string comparison is : " + bCompareResult);

        // Character at: This would return the single character at index value from the string
        char cIndex = sPopularTopic_1.charAt(5);
        System.out.println("The fifth character of popular topic is : " + cIndex);

        // Contains: This would return 'true' if passed string is contained in another string
        boolean bContainResult = sPopularTopic_1.contains("Framework");
        System.out.println("The result of string Framework is contained in the string sPopularTopic_1 is: " + bContainResult);

        // Index of: this would return the starting index of the passed string
        int iIndex = sPopularTopic_1.indexOf("Framework");
        System.out.println("The start index of the string Framework is : " + iIndex);

        // Substring First index: This would return the sub string of the string from the passed index number
        String sSubstring = sPopularTopic_1.substring(iIndex);
        System.out.println("The sub string from the index number is : " +sSubstring);

        // Substring First and Last index: This would return the sub string from first index to to end index
        sSubstring = sPopularTopic_1.substring(8,19);
        System.out.println("The sub string of popular topic 1 from index 8 to 18 is: " + sSubstring);

        // To lower case: It would return the complete string in the lowercase
        String sLowerCase = sPopularTopic_1.toLowerCase();
        System.out.println("The lower case of the popular topic 1 is : " + sLowerCase);

        // Split: It breaks the string into two parts from the passed argument and stores it into array
        String[] aSplit = sPopularTopic_1.split("automation");
        System.out.println("The first part of the array is: " + aSplit[0]);
        System.out.println("The last part of the array is : " + aSplit[1]);

    }
}
