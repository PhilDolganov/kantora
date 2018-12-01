package menus;

public class OnlyUnique {
    public static void main(String[] args) {
        int[] numbers = {25,52,25,65,8,96,8,25};;
        String s = "";
        for (int i = 0; i < numbers.length; i++) {
            if (!s.contains(String.valueOf(numbers[i])))
                s += numbers[i] + ",";
        }
        String stringArray[] = s.split(",");
        int[] uniquenum = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++)
            uniquenum[i] = Integer.parseInt(stringArray[i]);
        for (int i = 0; i < uniquenum.length; i++) {
            System.out.print(uniquenum[i] + ",");
        }
    }

}
