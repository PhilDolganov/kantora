package oopconceptpart1;

public class FunctionsInJava {

    public static void main(String[] args){
        FunctionsInJava obj = new FunctionsInJava();
        obj.test();
        int l = obj.pqr();
        System.out.println(l);
        String s1 = obj.qa();
        System.out.println(s1);
        int div = obj.division(30,10);
        System.out.println(div);
    }
    // non-static methods

    // void -- does not return anything
    public void test(){
        System.out.println("test method");
    }
    // return type - int
    public int pqr(){
        System.out.println("pqr method");
        int a = 10;
        int b = 20;
        int c = a+b;
        return c;
    }

    public String qa(){
        System.out.println("qa method");
        String s = "Selenium";
        return s;
    }

    // x,y --> input args
    public int division(int x, int y){
        System.out.println("division method");
        int d = x/y;
        return d;
    }
}
