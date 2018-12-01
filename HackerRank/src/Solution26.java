import java.time.LocalDate;
import java.util.Scanner;

public class Solution26 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        LocalDate returnDate = readDate(scan);
        LocalDate expectedDate = readDate(scan);
        scan.close();

        int fine;
        if (returnDate.isEqual(expectedDate) || returnDate.isBefore(expectedDate)){
            fine = 0;
        } else if (returnDate.getMonth() == expectedDate.getMonth() && returnDate.getYear() == expectedDate.getYear()){
            fine = 15 * (returnDate.getDayOfMonth() - expectedDate.getDayOfMonth());
        } else if (returnDate.getYear() == expectedDate.getYear()){
            fine = 500 * (returnDate.getMonthValue() - expectedDate.getMonthValue());
        } else {
            fine = 1000;
        }
        System.out.println(fine);
    }

    private static LocalDate readDate(Scanner scan) {
        int day = scan.nextInt();
        int month = scan.nextInt();
        int year = scan.nextInt();
        return LocalDate.of(year,month,day);
    }
}
