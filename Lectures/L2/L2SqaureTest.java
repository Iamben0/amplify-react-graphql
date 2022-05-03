public class L2SqaureTest {
    public static void main(String[] args) {
        testSquareV1();
        testSquareV2();
        testSquareV3();
    }

    public static void testSquareV1() {
        L2SqareV1 sq = new L2SqareV1();     //JVM will call a method by it name aka default constructor
        System.out.println(sq);
    }

    public static void testSquareV2() {
        L2SqareV2 sq = new L2SqareV2(10);
        System.out.println(sq);
    }

    public static void testSquareV3() {
        L2SqareV3 sq1 = new L2SqareV3();
        System.out.println(sq1);
        L2SqareV3 sq2 = new L2SqareV3(10);
        System.out.println(sq2);
    }
}

// Square class ver 3
class L2SqareV3 {
    private double side;
    
    // Provide multiple constructor (overloading)
    public L2SqareV3() {
        side = 1;   // More reasonable default value
    }

    public L2SqareV3(double sqSide) {
        side = sqSide;
    }

    public double getSide() {
        return side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter () {
        return side * 4;
    }

    public String toString() {
        return "Square with area " + getArea(); 
    }
 }

// Square class ver 2
class L2SqareV2 {
    private double side;
    // Java complier will not generate default constructor if a constrcutor is defined
    public L2SqareV2(double sqSide) {
        side = sqSide;
    }
    public double getSide() {
        return side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter () {
        return side * 4;
    }

    public String toString() {
        return "Square with area " + getArea(); 
    }
}

// A square class ver 1
class L2SqareV1 {
    private double side;
    // The java compiler will generated a default construcstor if there is NO constrcutor defined in the class
    public double getSide() {
        return side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter () {
        return side * 4;
    }

    public String toString() {
        return "Square with area " + getArea(); 
    }
}

