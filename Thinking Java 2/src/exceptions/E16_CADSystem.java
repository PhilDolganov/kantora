package exceptions;

public class E16_CADSystem {
    public static void main(String[] args){
        reusing.book.CADSystem x = new reusing.book.CADSystem(47);
        try {
            return;
        } finally {
            x.dispose();
        }
    }
}
