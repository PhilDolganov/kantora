package exceptions;

import java.io.FileInputStream;

public class E26_MainException {
    // Pass all exceptions to the console:
    public static void main(String[] args) throws Exception {
        // Open the file:
        FileInputStream file = new FileInputStream("DoesnotExist.file");
        // Use the file...
        // Cloe the file...
        file.close();
    }
}
