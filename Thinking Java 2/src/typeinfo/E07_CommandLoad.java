package typeinfo;
// {Args: typeinfo.Gum typeinfo.Cookie}

public class E07_CommandLoad {
    public static void main(String[] args) throws Exception {
        for (String arg : args)
            Class.forName(arg);
    }
}
