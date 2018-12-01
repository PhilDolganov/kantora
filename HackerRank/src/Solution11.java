import java.util.Scanner;

public class Solution11 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[][] arr = new int[6][6];
        int max = Integer.MIN_VALUE;
        int tempMax = 0;

        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (i + 2 < 6 && j + 2 < 6){
                    tempMax += arr[i][j] + arr[i][j+1] + arr[i][j+2];
                    tempMax += arr[i+1][j+1];
                    tempMax += arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];

                    if (tempMax > max){
                        max = tempMax;
                    }
                    tempMax = 0;
                }
            }
        }
        System.out.println(max);
    }
}
