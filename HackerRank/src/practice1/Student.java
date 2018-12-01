package practice1;

import static java.lang.Math.round;

public class Student extends Person {
    private int[] testScores;

    public Student(String firstName, String lastName, int idNumber, int[] testScores) {
        super(firstName, lastName, idNumber);
        this.testScores = testScores;
    }
    public char calculate(){
        int sum = 0;
        char grade;
        for (int i = 0; i < testScores.length; i++) {
            sum += testScores[i];
        }
        double average = sum / testScores.length;
//        int roundAvg =Math.toIntExact(Math.round(average));
        if (average >= 90 && average <= 100){
            return grade = 'O';
        } else if (average >= 80 && average < 90){
            return grade = 'E';
        } else if (average >= 70 && average < 80){
            return grade = 'A';
        } else if (average >= 55 && average < 70){
            return grade = 'P';
        } else if (average >= 40 && average < 55){
            return grade = 'D';
        } else {
            return grade = 'T';
        }
    }
    static int[] arr = {56,90};
    public static void main(String[] args){
        Student vasek = new Student("Vasek", "Popov",245,arr);
        System.out.println(vasek);
        System.out.println(vasek.calculate());
    }
}
