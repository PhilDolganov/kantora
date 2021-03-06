package strings;

import java.util.Formatter;

class Turtle1 {
    private final String name;
    private final Formatter f;

    public Turtle1(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
    }
}
public class E03_TurtleRedirected {
    public static void main(String[] args){
        Formatter f = new Formatter(System.err);
        Turtle tommy = new Turtle("Tommy", f),
               terry = new Turtle("Terry", f);
        tommy.move(0,0);
        terry.move(4,8);
        tommy.move(3,4);
        terry.move(2,5);
        tommy.move(3,3);
        terry.move(3,3);
    }
}
