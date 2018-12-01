package basic.java;

public class ArrayConcept {
    public static void main(String[] args){

        // array: to store similar data type values in an array variable
        // one dim array
        // 1. int array:
        // lowest bound/index = n-1(n is size of array)

        //disadvantages of array:
        //1.size is fixed - static array -- to overcome this problem, we use Collections -- ArrayList, HashTable -- dynamic array
        //2.stores only similar data types -- to overcome this problem, we use Object array

        int[] i = new int[4];
        i[0] = 10;
        i[1] = 20;
        i[2] = 30;
        i[3] = 40;

        System.out.println(i[2]);
        System.out.println(i.length);

        // Print all values of array: use for loop

        for (int j = 0; j < i.length ; j++) {
            System.out.println(i[j]);
        }

        //2. double array
        double d[] = new double[3];
        d[0] = 12.33;
        d[1] = 13.44;
        d[2] = 45.55;
        System.out.println(d[2]);

        // 3. char array;
        char[] c = new char[3];
        c[0] = 'q';
        c[1] = 2;
        c[2] = '$';

        // 4. Object array - used to store different data type values
        Object[] ob = new Object[6];
        ob[0] = "Tom";
        ob[1] = 25;
        ob[2] = 12.33;
        ob[3] = 1/1/1990;
        ob[4] = 'M';
        ob[5] = "London";

        System.out.println(ob[5]);
        System.out.println(ob.length);

    }

}
