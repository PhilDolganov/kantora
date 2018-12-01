package practice1;

public class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    public Person(String firstName, String lastName, int idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }

    // Print person data
    public void printPerson(){
        System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
    }
}
