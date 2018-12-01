
import java.util.HashMap;

public class Duplicates {
    public static void main (String[] args){
        String[] names = {"Papa", "Tony", "Vlad", "Tony"};
        int namesSize = names.length;
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < namesSize; i++)
            map.put(names[i], "1");
        if (namesSize == map.size())
            System.out.println("No duplicates");
        else
            System.out.println("There are duplicates");
    }
}
