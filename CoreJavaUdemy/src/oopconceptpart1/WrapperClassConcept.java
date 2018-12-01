package oopconceptpart1;

public class WrapperClassConcept {

    public static void main(String[] args){

        String x = "100";
        System.out.println(x+20);

        //data conversion from string to int:
        int i = Integer.parseInt(x);
        System.out.println(i+20);

        //Integer, Double, Character, Boolean

        // String to double
        String y = "12.33";
        double d = Double.parseDouble(y);
        System.out.println(d);

        //Sting to boolean
        String k = "true";
        boolean b = Boolean.parseBoolean(k);

        //int to String conversion:
        int j = 200;
        String s = String.valueOf(j);
        System.out.println(s+20);

        String u = "100A";
        Integer.parseInt(u);// NumberFormatException
    }
}
