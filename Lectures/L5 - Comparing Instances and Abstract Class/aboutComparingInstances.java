public class aboutComparingInstances {
    public static void main(String[] args) {
        L5Cone c1 = new L5Cone(1, 5);
        L5Cone c2 = new L5Cone(1, 5);
        L5Cone c3 = new L5Cone(1, 8);

        // Comparing
        System.out.println(c1 == c2);           //return false
        System.out.println(c1 == c3);           //return false
        
        // Compare "content" of c1 and c2
        System.out.println(c1.sameAs(c2));      // return true
        System.out.println(c1.sameAs(c3));      // return false


    }
}

class L5Cone {
    private double radius;
    private double height;
    
    public L5Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public boolean sameAs(L5Cone c) {
        // Must return true or false
        return (getHeight() == c.getHeight() && getRadius() == c. getRadius());
    }
}

    