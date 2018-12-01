package typeinfo;
// Copy-pasted because these interfaces are not public

import static net.mindview.util.Print.print;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
//    Toy() {}
    Toy(int i) {}
}
class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() { super(1);}
}
public class E01_ToyTest {
    static void printInfo(Class<?> cc) {
        print("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        print("Simple name: " + cc.getSimpleName());
        print("Canonical name : " + cc.getCanonicalName());
    }
    public static void main(String[] args){
        Class<?> c = null;
        try {
            c = Class.forName("typeinfo.FancyToy");
        } catch (ClassNotFoundException e){
            print("Can't find FancyToy");
            return;
        }
        printInfo(c);
        for (Class<?> face: c.getInterfaces())
            printInfo(face);
        Class<?> up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor:
            obj = up.newInstance();
        } catch (InstantiationException  e){
            print("Cannot instantiate");
            return;
        } catch (IllegalAccessException e){
            print("Cannot access");
            return;
        }
        printInfo(obj.getClass());
    }
}


