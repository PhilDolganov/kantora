package interfaces;

import static net.mindview.util.Print.print;

interface Rdent2 {
    void hop();
    void scurry();
    void reproduce();
}
class Mouse2 implements Rdent2 {
    public void hop() {print("Mouse hopping");}
    public void scurry(){print("Mouse scurrying");}
    public void reproduce(){print("Making more Mice");}
    public String toString() { return "Mouse"; }
}
class Gerbil2 implements Rdent2 {
    public void hop() {print("Gerbil hopping");}
    public void scurry(){print("Gerbil scurrying");}
    public void reproduce(){print("Making more Gerbils");}
    public String toString() { return "Gerbil"; }
}
class Hamster2 implements Rdent2 {
    public void hop() {print("Hamster hopping");}
    public void scurry(){print("Hamster scurrying");}
    public void reproduce(){print("Making more Hamsters");}
    public String toString() { return "Hamster"; }
}
public class E07_RodentInterface {
    public static void main(String[] args) {
        Rdent2[] rodents = {
                new Mouse2(),
                new Gerbil2(),
                new Hamster2(),
        };
        for (Rdent2 r : rodents) {
            r.hop();
            r.scurry();
            r.reproduce();
            print(r);
        }
    }
}
