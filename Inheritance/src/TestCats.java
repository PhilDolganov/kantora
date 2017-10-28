public class TestCats {

    public static void main(String[] args){
        Cat c = new Cat("Fat cat","Mary");
        String type = c.getType();
        System.out.println(type);
        c.meow();

    }
}
