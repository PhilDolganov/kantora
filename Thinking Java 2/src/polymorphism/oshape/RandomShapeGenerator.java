package polymorphism.oshape;

import polymorphism.book.shape.Circle;
import polymorphism.book.shape.Shape;
import polymorphism.book.shape.Square;
import polymorphism.book.shape.Triangle;

import java.util.Random;

import static net.mindview.util.Print.print;

// A "factory" that randomly creates shapes.
public class RandomShapeGenerator {
    private Random rand = new Random(47);
    public Shape next() {
        switch (rand.nextInt(3)){
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
        }
    }
}
//public class Square extends Shape {
//    @Override public void draw() {print("Square.draw()");}
//    @Override public void erase() {print("Square.erase()");}
//}
//public class Triangle extends Shape {
//    @Override public void draw() {print("Triangle.draw()");}
//    @Override public void erase() {print("Triangle.erase()");}
//}
//public class Circle extends Shape {
//    @Override public void draw() {print("Circle.draw()");}
//    @Override public void erase() {print("Circle.erase()");}
//}
