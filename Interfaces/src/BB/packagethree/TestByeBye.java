package BB.packagethree;

public class TestByeBye {
    public static void main (String[] args){
        Bye b = new ByeBye();
        b.bye("Yana");
        b = new SeeYou();
        b.bye("Lena");
    }
}
