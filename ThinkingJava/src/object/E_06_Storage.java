package object;

public class E_06_Storage {
    String s = "Hello, World!";
    int storage(String s){
        return s.length() * 2;
    }
    void print(){
        System.out.println("storage(s) = "+storage(s));
    }
    public static void main (String[] args){
        E_06_Storage st = new E_06_Storage();
        st.print();
    }
}
