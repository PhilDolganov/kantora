package oopconceptpart1;

public class OverloadMethod {
    int area;
    public void getArea(int length, int width){
        area = length * width;
        System.out.println("Area of Square is : " + area);
    }

    public void getArea(float length, int width){
        float area = length * width;
        System.out.println("Area of Square is (float): " + area);
    }

    public void getArea(int len, int wid, int height){
        area = len * wid * height;
        System.out.println("Area of rectangular is : " + area);
    }
    public static void main(String[] args){
        OverloadMethod overMeth = new OverloadMethod();
        overMeth.getArea(4f,4);
        overMeth.getArea(4,3,2);
    }
}
