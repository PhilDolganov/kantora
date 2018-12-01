public class Point {
    private double x;
    private double y;

    public double distanceFromOrigin() {
        return Math.sqrt(x * x+ y * y);
    }
 // constructor
    public Point(double xx, double yy){
        x = xx;
        y = yy;
    }

    public Point(){
        x = 0;
        y = 0;
    }
}
