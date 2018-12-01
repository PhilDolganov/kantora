package oops.java;

public class Loan {

    private int interestRate;
    private int borowerAge;
    private String loanPeriod;

    public void setInterestRate(int interestRates) {
        if (interestRates >= 2 && interestRates <= 8 ){
            interestRate = interestRates;
        } else {
            System.out.println("Please enter valid interest rates, values between 2-8");
        }

    }

    public void setBorowerAge(int age) {
        borowerAge = age;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public int getBorowerAge() {
        return borowerAge;
    }

    public void printInterestRate(){
        System.out.println("HomeLoan interest rate is:  " + interestRate);
    }

    public  void printLoanTenure(){
        System.out.println("HomeLoan Tenure is: " + loanPeriod);
    }
}
