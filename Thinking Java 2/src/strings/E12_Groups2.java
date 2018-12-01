package strings;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

public class E12_Groups2 {
    public static void main(String[] args){
        Set<String> words = new HashSet<String>();
        Matcher m = Pattern.compile("\\b((?![A-Z])\\w+)\\b").matcher(Groups.POEM);
        while (m.find())
            words.add(m.group(1));
        print("Number of unique words = " + words.size());
        print(words.toString());
    }
}
