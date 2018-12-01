public class TestPoint {
    public static void main(String[] args){

        Point p = new Point(3, 4);
        Point p2 = new Point();

        double distance = p.distanceFromOrigin();
        System.out.println("Distance is "+distance);

        p2.distanceFromOrigin();
    }
}
