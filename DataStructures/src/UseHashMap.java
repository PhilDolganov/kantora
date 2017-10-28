import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UseHashMap {
    public static void main (String[] args){

        Map<String, String> fruits = new HashMap<String, String>();
        fruits.put("apple", "red");
        fruits.put("peach", "yellow");
        fruits.put("guava", "green");
        fruits.put("orange", "yellow");

        String f = fruits.get("orange");
        System.out.println(f);

        Set<String> keys = fruits.keySet();

        for (String key: keys)
             System.out.println(key);

        System.out.println(keys);
    }
}
