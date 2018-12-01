package strings;
// {Args: E15_JGrep2.java "\b[Ssct]\w+" CASE_INSENSITIVE}

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

public class E15_JGrep2 {
    public static void main(String[] args) throws Exception {
        if (args.length < 3){
            print("Usage: java E15_JGrep2 file regex pattern");
            print("pattern can take one of the following values");
            print("CANON_EQ, CASE_INSENSETIVE, COMMENTS, " +
                    "DOTALL, MULTILINE, UNICODE_CASE, UNIX_LINES");
            System.exit(0);
        }
        int flag = 0;
        if (args[2].equalsIgnoreCase("CANON_EQ")){
            flag = Pattern.CANON_EQ;
        } else if (args[2].equalsIgnoreCase("CASE_INSENSETIVE")){
            flag = Pattern.CASE_INSENSITIVE;
        } else if (args[2].equalsIgnoreCase("COMMENTS")){
            flag = Pattern.COMMENTS;
        } else if (args[2].equalsIgnoreCase("DOTALL")){
            flag = Pattern.DOTALL;
        } else if (args[2].equalsIgnoreCase("MULTILINE")){
            flag = Pattern.MULTILINE;
        } else if (args[2].equalsIgnoreCase("UNICODE_CASE")){
            flag = Pattern.UNICODE_CASE;
        } else if (args[2].equalsIgnoreCase("UNIX_LINES")){
            flag = Pattern.UNIX_LINES;
        }
        Pattern p = Pattern.compile(args[1], flag);
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher(" ");
        for (String line : new TextFile(args[0])){
            m.reset(line);
            while (m.find())
                print(index++ + ": " + m.group() + ": " + m.start());
        }
    }
}
