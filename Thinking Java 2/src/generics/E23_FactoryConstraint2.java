package generics;

interface FactoryII<T>{
    T create(int arg);
}
class Foo<T>{
    private T x;
    public Foo(FactoryII<T> factory) {
        x = factory.create(1);
    }
}
class IntegerFactoryI implements FactoryII<Integer>{
    @Override
    public Integer create(int arg) {
        return new Integer(arg);
    }
}
class WidgetI {
    private final int id;
    WidgetI(int ident) {id = ident; }

    @Override
    public String toString() {
        return "widgetI " + id;
    }
    public static class Factory implements FactoryII<WidgetI>{
        @Override
        public WidgetI create(int arg) {
            return new WidgetI(arg);
        }
    }
}
public class E23_FactoryConstraint2 {
    public static void main(String[] arg){
        new Foo<Integer>(new IntegerFactoryI());
        new Foo<WidgetI>(new WidgetI.Factory());
    }
}
