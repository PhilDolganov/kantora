import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWrite {
    public static void main (String[] args) throws FileNotFoundException {

        File writeFile = new File("C:/Users/phild_000/IdeaProjects/docwrite.txt");
        PrintWriter pw = new PrintWriter(writeFile);
        pw.println("I like to drink vermut.");
        pw.println("I like to drink water.");
        pw.close();

        File readFile = new File("C:/Users/phild_000/IdeaProjects/docwrite.txt");
        try {
            Scanner s = new Scanner(readFile);
            while (s.hasNext())
                System.out.println(s.nextLine());
            s.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

}
