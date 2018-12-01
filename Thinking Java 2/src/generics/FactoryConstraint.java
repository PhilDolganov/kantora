package generics;

interface FactoryI<T> {
    T create(int arg);
}
class Foo2<T> {
    private T x;
    public <F extends FactoryI<T>> Foo2(F factory){
        int arg = 0;
        x = factory.create(arg);
    }
}
class IntegerFactory implements FactoryI<Integer> {
    @Override
    public Integer create(int arg) {
        return new Integer(0);
    }
}
class Widget {
    public static class Factory implements FactoryI<Widget> {
        public Widget create(int arg) {
            return new Widget();
        }
    }
}
public class FactoryConstraint {
    public static void main(String[] args){
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}
