package holding;

import net.mindview.util.TextFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class E25_WordsInfo3 {
    public static void main(String[] args){
        Map<String, ArrayList<Integer>> stat = new HashMap<String, ArrayList<Integer>>();
        int wordCount = 0;
        for (String word: new TextFile("E25_WordsInfo3.java", "\\W+")){
            ArrayList<Integer> loc = stat.get(word);
            if (loc == null){
                loc = new ArrayList<Integer>();
                stat.put(word, loc);
            }
            loc.add(++wordCount);
        }
        System.out.println(stat);
    }
}
