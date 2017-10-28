import java.util.ArrayList;

public class UseArrayList {
    public static void main (String[] args){
        ArrayList<String> names = new ArrayList<String>();

        names.add("Ann");
        names.add("Cindy");
        names.add(1,"Bob"); // ann, bob, cindy
        names.remove(0); // bob, cindy
        names.set(0,"Bill"); // bill, cindy

        System.out.println(names.get(1));
    }
}
