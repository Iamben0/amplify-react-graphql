import java.util.ArrayList;

public class L3InheritanceExample {
    public static void main(String[] args) {
        L3Circle circle = new L3Circle(10);
        System.out.println(circle.getArea());
        // System.out.println(circle.getVolume());

        // Test the subclass
        L3Cone cone = new L3Cone(10, 1);
        System.out.println(cone.getArea());
        System.out.println(cone.getVolume());

        // Array of Class
        L3Circle[] roundThings = new L3Circle[5];               // roundThings is a reference to a L3Circle
        roundThings[0] = new L3Circle(1);               // Create a instance of circle, save it into array roundThings
        roundThings[1] = new L3Cone(1, 5);      // Create a instance of cone, save it into array roundThings
        roundThings[2] = new L3Cone(5, 10);
        roundThings[3] = new L3Circle(10);

        // Access instances in the array
        System.out.println("Printing array area");
        for (int i = 0; i < roundThings.length; i++) {
            if (roundThings[i] != null) {
                System.out.println(roundThings[i].getArea());
            }
        }
        printConeOnly(roundThings);

        // Using  ArrayList
        ArrayList<L3Circle> circularThings = new ArrayList<L3Circle>();

        // Add instances to the ArrayList
        circularThings.add(new L3Circle(1));
        circularThings.add(new L3Cone(1, 5));
        circularThings.add(new L3Cone(5, 10));
        circularThings.add(new L3Circle(10));
        System.out.println("Printing ArrayList area");
        for (int i = 0; i < circularThings.size(); i++) {
            System.out.println(circularThings.get(i).getArea());
        }
    }

    public static void printConeOnly(L3Circle[] data) {
        System.out.println("Print Cone only volume");
        for (int i = 0; i < data.length; i++) {
            if(data[i] != null) {               
                // if object is an instance of L3Cone
                if (data[i] instanceof L3Cone) {
                    L3Cone temp = (L3Cone)data[i];      // same as type casting, ie. int temp = (int) (double variable)
                    System.out.println(temp.getVolume());
                }
            }
        }
    }
}

class L3Circle {
    private double radius;

    public L3Circle(double cRadius) {
        if (cRadius > 0)
            radius = cRadius;
        else 
            radius = 1;
        }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class L3Cone extends L3Circle {
     private double height;

    public L3Cone(double cHeight, double cRadius) {
        super(cRadius);
        height = cHeight;
    }

    public double getVolume() {
        return getArea() * height / 3;
    }
}

