package com.javafortesters.chap015stringsrevisited.examples;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClassExamples15 {

    @Test
    public void escapeCharacters(){
        System.out.println("New lines, and Tabs");
        String firstLine = "|first line\n";
        String secondLine = "|\tsecond line\n";
        String thirdLine = "|\t\tthird line\n";
        String fullLine = firstLine + secondLine + thirdLine;
        System.out.println(fullLine);

        System.out.println("Carriage return after each word");
        System.out.println("one\rtwp\rthree\rfour\rfive\r");

        System.out.println("Backspace after each word");
        System.out.println("one\btwo\bthree\bfour\bfive\b");

        System.out.println("Quotes and slashes");
        System.out.println("Bob\'s toy said \"DOS \'\\\'\"");
    }

    @Test
    public void stringConcatenation(){
        String ps1 = "This is " + "String2";
        assertThat(ps1, is("This is String2"));
        String ps2 = "This is " + 4;
        assertThat(ps2, is("This is 4"));

        String thisIs = "This is ";
        String s1 = thisIs.concat("String1");
        assertThat(s1, is("This is String1"));
    }

    @Test
    public void convertingToFromAString(){
        String intConcatConvert = "" + 1;
        assertThat(intConcatConvert, is("1"));

        String integerIntConvert = Integer.toString(2);
        assertThat(integerIntConvert, is("2"));

        String integerStringConvert = String.valueOf(3);
        assertThat(integerStringConvert, is("3"));
    }

    @Test
    public void convertingFromAString(){
        assertThat(Integer.valueOf("2"), is(2));

        char[] cArray = {'2','3'};
        assertThat("23".toCharArray(), is(cArray));

        byte[] bArray = "hello there".getBytes();
    }

    @Test
    public void canConvertBytesUTF8() throws UnsupportedEncodingException {
        byte[] b8Array = "hello there".getBytes("UTF8");
    }

    @Test
    public void constructors(){
        String empty = new String();
        assertThat(empty.length(), is(0));
    }

    @Test
    public void canConstructStrings(){

        char[] cArray = {'2','3'};
        assertThat(new String(cArray), is("23"));
        assertThat(new String(cArray, 1, 1), is("3"));

        byte[] bArray = "hello there".getBytes();
        assertThat(new String(bArray, 3,3), is("lo "));

        byte[] b8Array = new byte[0];
        try {
            b8Array = "hello there".getBytes("UTF8");
            assertThat(new String(b8Array, 3,3,"UTF8"),is("lo "));
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        String hello = new String("hello" + " " + "there");
        assertThat(hello, is("hello there"));
    }

    @Test
    public void comparingStrings(){
        String hello = "Hello";
        assertThat(hello.compareTo("Hello"), is(0));
        assertThat(hello.compareTo("hello") < 0, is(true));
        assertThat(hello.compareTo("Helloo") < 0, is(true));
        assertThat(hello.compareTo("Hemlo") < 0, is(true));

        assertThat(hello.compareTo("H") > 0, is(true));
        assertThat(hello.compareTo("Helln") > 0, is(true));
        assertThat(hello.compareTo("HeLlo") > 0, is(true));

        assertThat(hello.compareToIgnoreCase("hello"), is(0));
        assertThat(hello.compareToIgnoreCase("Hello"), is(0));
        assertThat(hello.compareToIgnoreCase("HeLlo"), is(0));
    }

    @Test
    public void contains(){
        String hello = "Hello";
        assertThat(hello.contains("He"), is(true));
        assertThat(hello.contains("Hello"), is(true));

        assertThat(hello.contains("LL"), is(false));
        assertThat(hello.contains("z"), is(false));
    }

    @Test
    public void contentEquals(){
        String hello = "Hello";
        assertThat(hello.contentEquals("Hello"), is(true));
        assertThat(hello.contentEquals("hello"), is(false));
        assertThat(hello.equalsIgnoreCase("hello"), is(true));
    }

    @Test
    public void endsWithStartsWith(){
        String hello = "Hello";
        assertThat(hello.endsWith("Hello"), is(true));
        assertThat(hello.endsWith(""), is(true));
        assertThat(hello.endsWith("lo"), is(true));

        assertThat(hello.startsWith("Hello"), is(true));
        assertThat(hello.endsWith(""), is(true));
        assertThat(hello.startsWith("He"), is(true));

        assertThat(hello.startsWith("he"), is(false));
        assertThat(hello.startsWith("Lo"), is(false));
    }

    @Test
    public void isEmpty(){
        String empty = "";
        assertThat(empty.isEmpty(), is(true));
        assertThat(empty.length(), is(0));
    }

    @Test
    public void regionMatches(){
        String hello = "Hello fella";
        assertThat(hello.regionMatches(true, 6, "fez", 0, 2), is(true));
        assertThat(hello.regionMatches(true, 9, "young lady", 6, 2), is(true));
    }

    @Test
    public void indexOf(){
        String hello = "Hello fella";
        assertThat(hello.indexOf("l"), is(2));
        assertThat(hello.lastIndexOf("l"), is(9));

        assertThat(hello.indexOf('l', 3), is(3));
        assertThat(hello.indexOf("l",4), is(8));

        assertThat(hello.lastIndexOf('l', 8),is(8));
        assertThat(hello.lastIndexOf("l",7), is(3));
        assertThat(hello.indexOf('z'), is(-1));
        assertThat(hello.lastIndexOf("z"), is(-1));
    }


    private List<Integer> findAllOccurrences(String string, String substring){
        List<Integer> results = new ArrayList<>();
        if (string == null || substring == null ){
            throw new IllegalArgumentException("Cannot search using null");
        }
        if (substring.isEmpty()){
            throw new IllegalArgumentException("Cannot search for Empty substring");
        }
        // set search to the start of the string
        int lastFoundPosition = 0;
        do {
            // try and find the substring
            lastFoundPosition = string.indexOf(substring, lastFoundPosition);
            // if we found it
            if (lastFoundPosition!=-1){
                //add it to the results
                results.add(lastFoundPosition);
                // next start after this index
                lastFoundPosition++;
            }
            // keep looking until we can't find it
        } while (lastFoundPosition!=-1);
        return results;
    }

    @Test
    public void canFindAllOccurrencesInStringUsingIndexOf(){
        List<Integer> results;
        results = findAllOccurrences("Hello fella", "l");

        assertThat(results.size(), is(4));

        assertThat(results.contains(2),is(true));
        assertThat(results.contains(3),is(true));
        assertThat(results.contains(8),is(true));
        assertThat(results.contains(9),is(true));

        assertThat(results.get(0), is(2));
        assertThat(results.get(1), is(3));
        assertThat(results.get(2), is(8));
        assertThat(results.get(3), is(9));
    }

    @Test
    public void worksWhenNothingToFind(){
        List<Integer> results;
        results = findAllOccurrences("Hello fella", "z");
        assertThat(results.size(), is(0));

        results = findAllOccurrences("", "z");
        assertThat(results.size(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForEmpty(){
        List<Integer> results = findAllOccurrences("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForNullString(){
        List<Integer> results = findAllOccurrences(null, "hello");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForNullSubString(){
        List<Integer> results = findAllOccurrences("hello",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForNulls(){
        List<Integer> results = findAllOccurrences(null,null);
    }

    private List<Integer> findAllOccurrencesLastIndexOf(String string, String substring){
        List<Integer> results = new ArrayList<>();
        if (string == null || substring == null ){
            throw new IllegalArgumentException("Cannot search using null");
        }
        if (substring.isEmpty()){
            throw new IllegalArgumentException("Cannot search for Empty substring");
        }
        // set search to the start of the string
        int lastFoundPosition = string.length();
        do {
            // try and find the substring
            lastFoundPosition = string.lastIndexOf(substring, lastFoundPosition);
            // if we found it
            if (lastFoundPosition!=-1){
                //add it to the results
                results.add(lastFoundPosition);
                // next start after this index
                lastFoundPosition--;
            }
            // keep looking until we can't find it
        } while (lastFoundPosition!=-1);
        return results;
    }

    @Test
    public void canFindAllOccurrencesInStringUsingLastIndexOf(){
        List<Integer> results;
        results = findAllOccurrencesLastIndexOf("Hello fella", "l");

        assertThat(results.size(), is(4));

        assertThat(results.contains(2),is(true));
        assertThat(results.contains(3),is(true));
        assertThat(results.contains(8),is(true));
        assertThat(results.contains(9),is(true));

        assertThat(results.get(0), is(9));
        assertThat(results.get(1), is(8));
        assertThat(results.get(2), is(3));
        assertThat(results.get(3), is(2));
    }

    @Test
    public void regexMustIncludeDigit(){
        String mustIncludeADigit = ".*[0123456789]+.*";
        assertThat("12345678".matches(mustIncludeADigit), is(true));
        assertThat("1nvalid".matches(mustIncludeADigit), is(true));
        assertThat("invalid".matches(mustIncludeADigit), is(false));
        assertThat("Invalid".matches(mustIncludeADigit), is(false));
    }

    @Test
    public void upperCaseLetter(){
        String mustIncludeUpperCase = ".*[A-Z]+.*";
        assertThat("Valid".matches(mustIncludeUpperCase),is(true));
        assertThat("val1D".matches(mustIncludeUpperCase),is(true));
    }

    @Test
    public void replacingStrings(){
        String hello = "Hello fella fella fella";

        assertThat(hello.replace("fella", "World"), is("Hello World World World"));
        assertThat(hello.replaceFirst("fella", "World"), is("Hello World fella fella"));
        assertThat(hello.replaceAll("fella", "World"), is("Hello World World World"));
    }

    @Test
    public void replaceNumbersWithString(){
        assertThat("1,2,3".replaceFirst("[0-9]","digit"),is("digit,2,3"));
        assertThat("1,2,3".replaceAll("[0-9]", "digit"), is("digit,digit,digit"));
    }

    @Test
    public void uppercaseAndLowercase(){
        String text = "In the lower 3rd";
        assertThat(text.toUpperCase(), is("IN THE LOWER 3RD"));
        assertThat(text.toLowerCase(), is("in the lower 3rd"));
    }

    @Test
    public void removingWhitespace(){
        String padded = "    trim me    ";
        assertThat(padded.length(), is(15));

        String trimmed = padded.trim();

        assertThat(trimmed.length(), is(7));
        assertThat(trimmed, is("trim me"));
    }

    @Test
    public void subStrings(){
        String digits = "0123456789";

        assertThat(digits.substring(5), is("56789"));
        assertThat(digits.substring(5,6), is("5"));
    }

    @Test
    public void stringFormat(){
        int value = 4;
        String output = "The value " + value + " was used";
        assertThat(output, is("The value 4 was used"));

        String template = "The value %d was used";
        String formatted = String.format(template, value);
        assertThat(formatted, is("The value 4 was used"));

        String use = "%s %s towards %d large %s";
        assertThat(String.format(use,"Bob","ran",6,"onions"), is("Bob ran towards 6 large onions"));

        String txt = "%2$s %4$s towards %3$d large %1$s";
        assertThat(String.format(txt, "Bob", "ran", 6, "onions"), is("ran onions towards 6 large Bob"));

        String txt2 = "%1$s %1$s towards %3$d large %1$s";
        assertThat(String.format(txt2, "Bob", "ran", 6, "onions"), is("Bob Bob towards 6 large Bob"));
    }

    @Test
    public void parsingWithSplit(){
        String csv = "1,2,3,4,5,6,7,8,9,10";
        String[] results = csv.split(",");

        assertThat(results.length, is(10));
        assertThat(results[0], is("1"));
        assertThat(results[9], is("10"));
    }

    @Test
    public void stringBuilder(){
        StringBuilder builder = new StringBuilder();

        builder.append("Hello there").replace(7,11,"World").delete(5,7);
        assertThat(builder.toString(), is("HelloWorld"));

        StringBuilder sb = new StringBuilder("hello");
    }

    @Test
    public void capacityManagement(){
        StringBuilder builder = new StringBuilder();
        assertThat(builder.capacity(), is(16));

        StringBuilder sblen = new StringBuilder(512);
        assertThat(sblen.capacity(), is(512));
        assertThat(sblen.toString().length(), is(0));

        builder.ensureCapacity(600);
        builder.trimToSize();
    }

    @Test
    public void appendingToStringBuilder(){
        StringBuilder builder = new StringBuilder();
        builder.append("> ");
        builder.append(1);
        builder.append(" + ");
        builder.append(2);
        char[] ca = {' ', '=', ' ', '3'};
        builder.append(ca);
        assertThat(builder.toString(), is("> 1 + 2 = 3"));
    }

    @Test
    public void capacitySizeIncreasesAutomaticallyWithAppend(){
        StringBuilder builder = new StringBuilder(5);
        assertThat(builder.capacity(), is(5));
        builder.append("Hello World");
        assertThat(builder.capacity() > 5, is(true));
    }

    @Test
    public void insertIntoStringBuilder(){
        StringBuilder builder = new StringBuilder("123890");
        builder.insert(3, "4567");
        assertThat(builder.toString(), is("1234567890"));
    }

    @Test
    public void writeATestToInsert(){
        StringBuilder builder = new StringBuilder("");
        // Insert at start
        builder.insert(0,"a");
        assertThat(builder.toString(), is("a"));

        // Insert to end
        builder.insert(builder.toString().length(),"b");
        assertThat(builder.toString(), is("ab"));

        // Insert to middle
        builder.insert(1, ".");
        assertThat(builder.toString(),is("a.b"));
    }

    @Test
    public void insertAChar(){
        char[] ca = {'.','a','b','c','d','e','f'};
        StringBuilder builder = new StringBuilder("abgh");
        // at position 2 in the string
        // insert from the char[] ca
        // starting at index 3 'c'
        // inclusive the next 4 indexes
        builder.insert(2, ca, 3,4);
        assertThat(builder.toString(), is("abcdefgh"));
    }

    @Test
    public void deletingFromStringBuilder(){
        StringBuilder builder = new StringBuilder("abcdefg");
        builder.delete(2,4);
        assertThat(builder.toString(), is("abefg"));
        builder.deleteCharAt(2);
        assertThat(builder.toString(), is("abfg"));
    }

    @Test
    public void replaceSubStringsAndCharacters(){
        StringBuilder builder = new StringBuilder("abcdefgh");
        builder.replace(0,4,"12345678");
        assertThat(builder.toString(), is("12345678efgh"));

        StringBuilder builder1 = new StringBuilder("012345678");
        builder1.setCharAt(5,'f');
        assertThat(builder1.toString(), is("01234f678"));
    }

    @Test
    public void reverseAString(){
        StringBuilder builder = new StringBuilder("0123456789");
        assertThat(builder.reverse().toString(), is("9876543210"));
    }

    @Test
    public void subString(){
        StringBuilder builder = new StringBuilder("0123456789");
        assertThat(builder.substring(3,7), is("3456"));
        assertThat(builder.substring(3), is("3456789"));
    }

}
