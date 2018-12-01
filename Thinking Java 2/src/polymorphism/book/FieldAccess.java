package polymorphism.book;
// Direct field access is determined at compile time.

class Super{
    public int field = 0;
    public int getField() {return field;}
}
class Sub extends Super {
    public int field = 1;
    public int getField() {return field;}
    public int getSupertField() {return super.field;}
}
public class FieldAccess {
    public static void main (String[] args){
        Super sup = new Sub(); // Upcast
        System.out.println("sup.field = " + sup.field + ", sup.getField() = " + sup.getField());
        Sub sub = new Sub();
        System.out.println("sub.field = " + sub.getField() + ", sup.getField() = "
                +sub.getField() + ", sup.getSuperField() = " + sub.getSupertField());
    }
}
