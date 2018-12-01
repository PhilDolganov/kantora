public class Arrays {

    public static void main(String[] args) {
        int[] array = new int[55];
        String[] str = new String[21];
        str[0] = new String("Vlad");
        str[1] = "Tony";

        for(int i = 0; i < str.length; ++i) {
            System.out.println(str[i]);
        }

        String[] var10000 = new String[]{"mama", "papa"};
        String[] books = new String[]{"War and Peace", "Farewell to Arms", "Hamlet"};
        String[] books2 = new String[]{"War and Peace", "Farewell to Arms", "Hamlet"};
        if (books == books2) {
            System.out.println("Equals");
        }

        if (java.util.Arrays.equals(books, books2)) {
            ;
        }

        System.out.println("Equals now");
    }

}
