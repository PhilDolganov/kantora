package typeinfo;

import static net.mindview.util.Print.print;

interface HasCPU {}

class FancierToy extends FancyToy implements HasCPU {}

public class E02_ToyTest2 {
    static void printInfo(Class<?> cc) {
        print("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        print("Simple name: " + cc.getSimpleName());
        print("Canonical name : " + cc.getCanonicalName());
    }
    public static void main(String[] args){
        Class<?> c = null;
        try {
            c = Class.forName("typeinfo.FancierToy");
        } catch (ClassNotFoundException e){
            print("Can't find FancierToy");
            System.exit(1);
    }
    printInfo(c);
        for (Class<?> face : c.getInterfaces())
            printInfo(face);
        Class<?> up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException  e){
            print("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e){
            print("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
        }
}

