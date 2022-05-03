public class L2GlassPaneTest {
    public static void main(String [] args) {
        L2GlassPane glass1 = new L2GlassPane(20, 10);

        System.out.println(glass1.getLength());
        glass1.setUnitCost(-1);                     // just to test -1 cannot be used due to validation
        System.out.println(glass1.getUnitCost());
        glass1.setUnitCost(0.01);
        System.out.println(glass1.getUnitCost());

        // Just an example
        double costOfPane = glass1.getCost();
        System.out.println("PLease pay $" + costOfPane);
        // Testing the toString
        System.out.println(glass1.toString());
        System.out.println(glass1);             // same result as previous statement
    }
}
