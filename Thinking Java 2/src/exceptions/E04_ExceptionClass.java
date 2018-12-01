package exceptions;
// Following the instructions to the letter:
class MyException1 extends Exception {
    String msg;
    public MyException1(String msg){
        this.msg = msg;
    }
    public void printMsg() {
        System.out.println("msg = " + msg);
    }
}

// Or take a more clever approach,
// noting that string storage and printing are
// built into Exception:
class MyException2A extends Exception {
    public MyException2A(String s) {super(s);}
}
public class E04_ExceptionClass {
    public static void main(String[] args) throws MyException1 {
        try {
            throw new MyException1("MyException message");
        } catch (MyException1 e) {
            e.printMsg();
        }
        try {
            throw new MyException2A("MyException2 message");
        } catch (MyException2A e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}
