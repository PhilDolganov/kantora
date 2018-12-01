package reusing;

import reusing.book.Detergent;

class NewDetergent extends Detergent {
    public void scrub() {
        append(" NewDetergent.scrub()");
        super.scrub(); // Doesn't have tp be first
    }
    public void sterilize() { append(" sterilize()");}
}
public class E02_NewDetergent {
    public static void main(String[] args){
        NewDetergent nd = new NewDetergent();
        nd.dilute();
        nd.scrub();
        nd.sterilize();
        System.out.println(nd);
    }
}
