package oops.java;

public class ABCbank extends Loan {

    public static void main(String[] args){
        ABCbank bank = new ABCbank();
        bank.setInterestRate(8);
        bank.printInterestRate();
    }
}
