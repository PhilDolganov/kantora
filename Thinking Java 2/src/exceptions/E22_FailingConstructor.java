package exceptions;

class ConsstructionException extends Exception {}

class FailingConstructor {
    FailingConstructor(boolean fail) throws ConsstructionException {
        if (fail) throw new ConsstructionException();
    }
}
public class E22_FailingConstructor {
    public static void main(String[] args){
        for (boolean b = false; ; b = !b)
            try {
            System.out.println("Constructing...");
            FailingConstructor fc = new FailingConstructor(b);
            try {
                System.out.println("Processing...");
            } finally {
                System.out.println("Cleanup...");
            }
            } catch (ConsstructionException e) {
            System.out.println("Construction has failed: " + e);
            break;
            }
    }
}
