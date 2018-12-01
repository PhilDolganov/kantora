package com.javafortesters.chap009arraysandforloopiteration.examples;

import com.javafortesters.domainentities.User;
import com.javafortesters.domainexceptions.InvalidPassword;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ClassExamples9 {

    String[] workdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    String[] workdays1 = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    @Test
    public void simpleArrayExample(){
        String[] numbers0123 = {"zero", "one", "two", "three"};

        for (String numberText : numbers0123){
            System.out.println(numberText);
        }
        assertEquals("zero", numbers0123[0]);
        assertEquals("three", numbers0123[3]);
    }

    @Test
    public void workDays(){

        String days = "";
        for (String workday : workdays) {
            days = days + "|" + workday;
        }
        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday", days);
    }

    @Test
    public void forEachWorkday(){
        String days = "";
        for (int i = 0; i < workdays.length ; i++) {
            days = days + "|" + workdays[i];
        }
        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday", days);
    }

    @Test
    public void forLoopsUsingIndexFixedCondition(){
        String days = "";

        for (int i = 0; i < 5; i++) {
            days = days + "|" + i + "-" + workdays[i];
        }

        assertEquals("|0-Monday|1-Tuesday|2-Wednesday|3-Thursday|4-Friday", days);
    }

    @Test
    public void forEachLoopsUsingIndexFixedCondition(){
        String days = "";
        int dayindex = 0;
        for (String workday : workdays) {
            days = days + "|" + workday;
            System.out.println("found " + workday + " at position " + dayindex);
            dayindex++;
        }
    }

    @Test
    public void createAnArrayOfUsers() throws InvalidPassword {
        User[] users = new User[3];

        users[0] = new User("bob", "bA55Word");
        users[1] = new User("eris", "eA55Word");
        users[2] = new User("ken", "kA55Word");

        assertEquals("bob", users[0].getUsername());
        assertEquals("eris", users[1].getUsername());
        assertEquals("ken", users[2].getUsername());

        for (User aUser : users) {
            System.out.println(aUser.getUsername());
        }
    }

    @Test
    public void copyAndResizeAnArray(){
        String[] weekdDays;
        weekdDays = Arrays.copyOf(workdays, 7);

        assertEquals(null, weekdDays[5]);
        assertEquals(null, weekdDays[6]);

        weekdDays[5] = "Saturday";
        weekdDays[6] = "Sunday";

    }

    @Test
    public void truncateAnArrayAndMakeItShorter(){
        String[] weekDays;
        weekDays = Arrays.copyOf(workdays, 3);

        assertEquals(3, weekDays.length);
        assertEquals("Monday", weekDays[0]);
        assertEquals("Tuesday", weekDays[1]);
        assertEquals("Wednesday", weekDays[2]);
    }

    @Test
    public void copyASubsetOfAnArray(){
        String[] weekDays = Arrays.copyOfRange(workdays, 2, 5);

        assertEquals(3, weekDays.length);
        assertEquals("Wednesday", weekDays[0]);
        assertEquals("Thursday", weekDays[1]);
        assertEquals("Friday", weekDays[2]);

        assertEquals(weekDays[0], workdays[2]);
        assertEquals(weekDays[1], workdays[3]);
        assertEquals(weekDays[2], workdays[4]);

    }

    @Test
    public void useCopyOfRangeToIncreaseArraySize(){
        String[] weekDays = Arrays.copyOfRange(workdays, 2, 7);

        assertEquals(5, weekDays.length);
        assertEquals("Wednesday", weekDays[0]);
        assertEquals("Thursday", weekDays[1]);
        assertEquals("Friday", weekDays[2]);
        assertEquals(null, weekDays[3]);
        assertEquals(null, weekDays[4]);
    }

    @Test
    public void sortWorkDays(){

        Arrays.sort(workdays1);

        assertEquals("Friday", workdays1[0]);
        assertEquals("Monday",workdays1[1]);
        assertEquals("Thursday", workdays1[2]);
        assertEquals("Tuesday",workdays1[3]);
        assertEquals("Wednesday",workdays1[4]);
    }

    @Test
    public void mixCaseSort(){
        String[] workdaysMixedCase = {"monday", "Tuesday", "Wednesday", "thursday", "Friday"};
        Arrays.sort(workdaysMixedCase);
        assertEquals(workdaysMixedCase[0], "Friday");
        assertEquals(workdaysMixedCase[1], "Tuesday");
        assertEquals(workdaysMixedCase[2], "Wednesday");
        assertEquals(workdaysMixedCase[3], "monday");
        assertEquals(workdaysMixedCase[4], "thursday");
    }

    @Test
    public void populateAnArrayWithData(){
        int[] tenItems = {0,0,0,0,0,1,1,1,1,1};

        // fill cells 5 - 9 with '2'
        Arrays.fill(tenItems, 5,10,2);

        //0 - 4 are untouched
        assertEquals(0, tenItems[0]);
        assertEquals(0, tenItems[4]);

        // 5 - 9 now equal 2
        assertEquals(2, tenItems[5]);
        assertEquals(2, tenItems[6]);
        assertEquals(2, tenItems[7]);
        assertEquals(2, tenItems[8]);
        assertEquals(2, tenItems[9]);
    }

    @Test
    public void sortAnArray(){
        int[] outOfOrder = {2,4,3,1,5,0};

        Arrays.sort(outOfOrder);

        assertEquals(0, outOfOrder[0]);
        assertEquals(1, outOfOrder[1]);
        assertEquals(2, outOfOrder[2]);
        assertEquals(3, outOfOrder[3]);
        assertEquals(4, outOfOrder[4]);
        assertEquals(5, outOfOrder[5]);
    }

    @Test
    public void exerciseCreateAnArrayOf100Users() throws InvalidPassword {
        User[] users = new User[100];

        for (int userIndex = 0; userIndex < 100; userIndex++) {
            int userId = userIndex + 1;
            users[userIndex] = new User("user" + userId,"password" + userId);
        }

        // check creation
        for (User aUser : users){
            System.out.println(aUser.getUsername() + ", " + aUser.getPassword());
        }
        // bonus points assert creation
        int userId = 1;
        for (User aUser : users){
            assertEquals("user" + userId, aUser.getUsername());
            assertEquals("password" + userId, aUser.getPassword());
            userId++;
        }
        // check the last one output was 100, i.e. next would be 101
        assertEquals(userId, 101);
    }

    @Test
    public void multiDimArray(){
        int[][] multi = new int[4][4];

        assertEquals(4, multi[0].length);
        assertEquals(0, multi[0][1]);

        int[][] multi1 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

        assertEquals(1, multi1[0][0]);
        assertEquals(7, multi1[1][2]);
        assertEquals(12, multi1[2][3]);
        assertEquals(14, multi1[3][1]);

        int[][][] multi3d = new int[3][4][5];
        assertEquals(3, multi3d.length);
        assertEquals(4, multi3d[0].length);
        assertEquals(4, multi3d[1].length);
        assertEquals(4, multi3d[2].length);
        assertEquals(5, multi3d[0][1].length);
        assertEquals(5, multi3d[0][2].length);
        assertEquals(5, multi3d[1][3].length);
        assertEquals(0, multi3d[0][0][0]);

        int[][] ragged2d = {{1,2,3,4}, {5,6},{7,8,9}};
        assertEquals(4, ragged2d[0].length);
        assertEquals(2, ragged2d[1].length);
        assertEquals(3, ragged2d[2].length);

        assertEquals(4, ragged2d[0][3]);
        assertEquals(6, ragged2d[1][1]);
        assertEquals(7, ragged2d[2][0]);

        int[][] ragged2d1 = new int[10][];
        ragged2d1[0] = new int[10];
        ragged2d1[1] = new int[3];
    }


    public void print2DIntArray(int [][]multi){
        for (int[] outer : multi){
            if (outer==null){
                System.out.print("null");
            } else {
                for (int inner : outer){
                    System.out.print(inner + ", ");
                }
            }
            System.out.println("");
        }
    }

    @Test
    public void createTriangle2dArray(){
        int[][]triangle = new int[16][];

        for (int row = 0; row < triangle.length ; row++) {
            triangle[row] = new int[row + 1];
            for (int i = 0; i < (row+1); i++) {
                triangle[row][i] = i;
            }
        }
        print2DIntArray(triangle);
    }
}
