package exceptions;

class YetAnotherException extends Exception {
    @Override
    public String toString() {
        return "Yet another exception";
    }
}
class LostMessage2 {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }
    void cleanup() throws YetAnotherException {
        throw new YetAnotherException();
    }
}
public class E18_LostMessage {
    public static void main(String[] args) {
        try {
            LostMessage2 lm = new LostMessage2();
            try {
                try {
                    lm.f();
                } finally {
                    lm.dispose();
                }
                } finally {
                    lm.cleanup();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }



