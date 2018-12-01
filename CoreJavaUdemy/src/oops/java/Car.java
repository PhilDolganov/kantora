package oops.java;

public class Car {
    // State of Object
    String name;
    int model;
    String fuelType;

    public void runningMode(){

    }

    public static void main(String[] args){
      // Objects || reference variables
        Car BMW = new Car();
        Car Audi = new Car();
        Car Hyundai = new Car();

        BMW.name = "x5";
        BMW.model = 2017;
        BMW.fuelType = "Hybrid";

        Audi.name = "A6";
        Audi.model = 2015;
        Audi.fuelType = "Diesel";

        Hyundai.name = "i20";
        Hyundai.model = 2019;
        Hyundai.fuelType = "Petrol";

        System.out.println(BMW.model);
        System.out.println(Hyundai.name);
    }
}
