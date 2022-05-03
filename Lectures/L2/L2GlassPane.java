public class L2GlassPane {
    private double length, width;           // instance variables
    private double unitCost;

    // constructor
    public L2GlassPane(double gLength, double gWidth) {
        // initialised the instance variables
        length = gLength;
        width = gWidth;
    }

    // getters
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getUnitCost() {
        return unitCost;
    }

    // setter
    public void setUnitCost(double cost) {
        if (cost > 0)               // validation
            unitCost = cost;
    }

    // some other useful methods
    public double getArea() {
        return length * width;
    }

    // area * unit cost
    public double getCost() {
        return getArea() * unitCost;    // can call other instance methods
    }

    public String toString() {
        return "Glass pane of area " + getArea();
    }
}
