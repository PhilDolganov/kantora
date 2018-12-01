package exceptions;

class MyRuntimException extends RuntimeException {
    public MyRuntimException(String s) { super(s);}
}
public class E28_RuntimeExceptionClass {
    public static void main(String[] args){
        throw new MyRuntimException("My RuntimeException msg");
    }
}
