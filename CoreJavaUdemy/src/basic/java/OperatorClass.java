package basic.java;

public class OperatorClass {

    int i = 100;
    int k = 100;
    int j = 200;

    public void relation(){
        System.out.println(i>k);
        System.out.println(i<k);
        System.out.println(i==k);
        System.out.println(i!=k);
    }

    public void secndMethod(){
        if (i==k || i==j){
            System.out.println("We are similar");
            if (i>j){
                System.out.println("");
            }
        } else {
            System.out.println("No dice");
        }
    }

    public static void main(String[] args){
        OperatorClass ope = new OperatorClass();
        ope.relation();
        ope.secndMethod();
    }
}
