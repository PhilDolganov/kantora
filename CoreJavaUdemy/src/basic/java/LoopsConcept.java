package basic.java;

public class LoopsConcept {

    public static void main(String[] args){

        // 1. while loop:

        int i = 1;
        while (i <= 10){
            System.out.println(i);
            i++;
        }
        System.out.println("*************************");
        // 2. for loop:

        for (int j = 0; j <= 10; j++){
            System.out.println(j);
        }
        System.out.println("*************************");
        // Print 10 to 1
        for (int k = 10; k>=1; k--){
            System.out.println(k);
        }
    }
}
