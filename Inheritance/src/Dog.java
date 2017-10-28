public class Dog extends Animal {
//instance variables
    private String name;
    private String breed;
 //constructor
    public Dog(String type, String aName, String aBreed){
        super(type);//call constructor of parent class
        name = aName;
        breed = aBreed;
    }
//getter
    public String getName() {
        return name;
    }
//getter
    public String getBreed() {
        return breed;
    }
}
