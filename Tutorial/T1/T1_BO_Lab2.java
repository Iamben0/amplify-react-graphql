import java.util.Scanner;

public class T1_BO_Lab2 {
    public static void main(String[] args) {
        Rectangle [] rects = new Rectangle[3];
        getRectInput(rects);
        printArray(rects);

    }

    public static void printArray(Rectangle[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i].getArea());
            System.out.println(data[i]);
        }
    }

    public static void getRectInput(Rectangle[] data) {
        Scanner input = new Scanner(System.in);
        double length1, width1;
        for (int i = 0; i < data.length; i++) {
            System.out.println("Please input length: ");
            length1 = input.nextDouble();
            System.out.println("Please input width: ");
            width1 = input.nextDouble();
            data[i] = new Rectangle(length1, width1);
        }
    }

}

class Rectangle {
    private double length, width;

    public Rectangle (double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public String toString() {
        return "Rectangle area = " + getArea();
    }
}
