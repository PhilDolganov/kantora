package strings;
// {Args: E19_JClassUsageReporter.java}

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E19_JClassUsageReporter {
    private static final String Identifier = "[$A-Za-z_][$A-Za-z_0-9]*";
    private static final String ClassOrInterfaceType = Identifier + "(?:\\." + Identifier + ")*";
    static final String CU_REP_REGEX = "class\\s+" + Identifier + "|extends\\s+" + ClassOrInterfaceType +
            "|new\\s+" + ClassOrInterfaceType;
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java E19_JClassUsageReporter file");
            System.exit(0);
        }
        String src = TextFile.read(args[0]);
        // Prune away comments ...
        src = src.replaceAll(E18_JStringExtractor.STR_EXT_REGEX, "");
        Pattern p = Pattern.compile(CU_REP_REGEX);
        Matcher m = p.matcher(src);
        while (m.find())
            System.out.println(m.group());
    }

}
