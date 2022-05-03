public class L4Cube extends L4Square {
    public L4Cube (double cLength) {
        super(cLength);
    }

    // Overrides getArea method to calculate
    // the area of a cube correctly
    @Override
    public double getArea() {
        return super.getArea() * 6;
    }

    // New method for Cube
    public double getVolume() {
        return super.getArea() * getLength();
    }

    @Override
    public String toString() {
        return "Cube with volume " + getVolume();
    }
}
