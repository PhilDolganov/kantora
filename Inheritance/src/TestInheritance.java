public class TestInheritance {

    public static void main (String[] args){
        Dog d = new Dog("A scary animal", "Tuzik", "Chihuahua");//created dog object with parameters
        System.out.println(d.getType());
        System.out.println(d.getName());
        System.out.println(d.getBreed());

        Animal a = new Animal("Mammal");//created new object using Animal constructor

        Animal d1 = new Dog("My pet", "Gavgav","Animal");

    }
}
