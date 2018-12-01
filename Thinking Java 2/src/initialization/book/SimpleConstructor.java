package initialization.book;
// Demonstration of a simple constructor

class Rock {
    Rock(){ // This is a simple constructor
        System.out.print("Rock ");
    }
}
public class SimpleConstructor {
    public static void main (String[] args){
        for (int i = 0; i < 10; i++)
            new Rock();
    }
}
