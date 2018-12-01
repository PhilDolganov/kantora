package car;

public class Car {
    int maxSpeed = 100;
    int minSpeed = 0;

    double weight = 4079;

    boolean isTheCarOn = false;
    char condition = 'A';
    String nameOfCar = "Lucy";

    double maxFuel = 16;
    double currentFuel = 8;
    double mpg = 26.4;

    int numberOfPeopleInCar = 1;
    int maxNumberOfPeopleInCar = 6;

    // f(x,y,z) = x +1/z-y;
    // Say x = 5;
    // f(5) = 5 + 1 = 6;
    public Car(){

    }

    public Car(int customMaxSpeed, double customWeight, boolean customIsTheCarOn){
        maxSpeed = customMaxSpeed;
        weight = customWeight;
        isTheCarOn = customIsTheCarOn;
    }

    // Getters and Setters
    public int getMaxSpeed(){
        return this.maxSpeed;
    }
    public void setMaxSpeed(int newMaxSpeed){
        this.maxSpeed = newMaxSpeed;
    }
    public int getMinSpeed(){
        return this.minSpeed;
    }
    public double getWeight(){
        return this.weight;
    }
    public boolean getIsTheCarOn(){
        return  this.isTheCarOn;
    }

    public void printVariables(){
        System.out.println("This is max speed " + maxSpeed);
        System.out.println(minSpeed);
        System.out.println(weight);
        System.out.println(isTheCarOn);
        System.out.println(condition);
        System.out.println(nameOfCar);
        System.out.println(numberOfPeopleInCar);
    }
    public void upgradeMaxSpeed(){
      setMaxSpeed(getMaxSpeed() + 10);
    }
    public void getIn(){
        // if there aren't too many people in the car
        if (numberOfPeopleInCar < maxNumberOfPeopleInCar) {
            // then someone can get in
            numberOfPeopleInCar++;
            System.out.println("Someone got in");
        } else {
            // otherwise print out the car is full
            System.out.println("The car is full! " + numberOfPeopleInCar + " = " + maxNumberOfPeopleInCar);
        }
    }

    public void getOut(){
        // if there's people in the car
        if (this.numberOfPeopleInCar > 0) {
            // then tell one person to get out
            numberOfPeopleInCar--;
        } else {
            // otherwise no one can get out
            System.out.println("No one is in the car " + numberOfPeopleInCar);
        }
    }

    public double howManyMilesTillOutOfGas(){
        return currentFuel * mpg;
    }

    public double maxMilesPerFillUp(){
        return maxFuel * mpg;
    }
    public void turnTheCarON(){
        // If the car isn't on...
       if (!isTheCarOn){
           // turn it on
           isTheCarOn = true;
       } else {
           // otherwise print out the fact it's on
           System.out.println("The Car is already on + " + isTheCarOn );
       }
    }

    public static void main(String[] args){
        Car tommyCar = new Car();
        tommyCar.getOut();
        tommyCar.getOut();
        tommyCar.getIn();
        tommyCar.getIn();
        tommyCar.getIn();
        tommyCar.getIn();
        tommyCar.getIn();
        tommyCar.getIn();
        tommyCar.getIn();
        tommyCar.turnTheCarON();
        tommyCar.turnTheCarON();

    }
}
