package polymorphism;

import polymorphism.newshape.*;

public class E04_NewShapeType {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(), new Square(), new Triangle(), new Tetrahedron()};

        // Make polymorphic methd calls:
        for (Shape shape : shapes) {
            shape.draw();
            shape.erase();
            shape.msg();
        }
    }
}
