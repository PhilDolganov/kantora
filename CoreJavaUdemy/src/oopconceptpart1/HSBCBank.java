package oopconceptpart1;

public class HSBCBank implements USBank, BrazilBank { // multiple inheritance
    //Is-a relationship

    // if a class is implementing an interface, then it is mandatory to define/override all methods of interface
    @Override
    public void credit() {
        System.out.println("hsbc -- credit");
    }

    @Override
    public void debit() {
        System.out.println("hsbc -- debit");
    }

    @Override
    public void transferMoney() {
        System.out.println("hsbc -- transferMoney");
    }

    public void educationLoan(){
        System.out.println("hsbc -- edu loan");
    }

    public void carLoan(){
        System.out.println("hsbc -- Car loan");
    }

    @Override
    public void mutualFund() {
        System.out.println("BrazilBank mutual fund");
    }
}
