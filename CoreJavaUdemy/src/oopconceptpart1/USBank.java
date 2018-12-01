package oopconceptpart1;

public interface USBank {

    int min_bal = 100;
    public void credit();
    public void debit();
    public void transferMoney();

    // only method declaration - no method body, only method prototype
    // in interface we can declare the variables, variables by default are static
    // value of variables can't be changed
    // no static methods in interface allowed
    // no main method
    // we can't create the object of interface - abstract in nature
}
