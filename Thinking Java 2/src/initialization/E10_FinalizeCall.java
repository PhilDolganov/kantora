package initialization;

public class E10_FinalizeCall {
    protected void finalize(){
        System.out.println("finalize() called");
    }
    public static void main (String[] args){
        new E10_FinalizeCall();
    }
}
