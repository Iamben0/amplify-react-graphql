public class L4Square {
    private double length;

    public L4Square(double sLength){
        length = sLength;
    }

    public double getLength(){
        return length;
    }

    public double getArea(){
        return length * length;
    }
    
    public String toString(){
        return "Square with area = " + getArea();
    }
}
