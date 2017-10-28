
public class Cat extends Animal {
    private String name;

    public Cat(String aType, String aName){
        super(aType);
        name = aName;
    }
    public void meow(){
        System.out.println("Cats can meow");
    }

}
