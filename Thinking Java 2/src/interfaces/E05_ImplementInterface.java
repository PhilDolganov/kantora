package interfaces;

import interfaces.ownpackage.AnInterface;

import static net.mindview.util.Print.print;

class ImplementInterface implements AnInterface {
    public void f() {print("ImplementInterface.f"); }
    public void g() {print("ImplementInterface.g"); }
    public void h() {print("ImplementInterface.h"); }
}
public class E05_ImplementInterface {
    public static void main(String[] args){
        ImplementInterface imp = new ImplementInterface();
        imp.f();
        imp.g();
        imp.h();
    }
}
