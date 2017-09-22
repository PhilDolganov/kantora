package operators;

public class E08_LongLiterals {
    public static void main (String[] args){
        long l1 = 0x2f; // Hexadecimal (lowercase)
        System.out.println(Long.toBinaryString(l1));
        long l2 = 0X2F; // Hexadecimal (uppercase)
        System.out.println(Long.toBinaryString(l2));
        long l3 = 0177; // Octal (leading zero)
        System.out.println(Long.toBinaryString(l3));
    }
}
