public class L4SquareCubeTest {
    public static void main(String[] args) {
      L4Square sq = new L4Square(10);
      System.out.println(sq.getArea());
      System.out.println(sq);

      // Test subclass isntance
      System.out.println("Test subclass instance");
      L4Cube cu = new L4Cube(10);
      System.out.println(cu.getArea());
      System.out.println(cu);

      // Base class reference subclass instance
      sq = cu;  // base class sq reference points to cu sublcass instance
      System.out.println("Test polymorphism");
      System.out.println(sq.getArea());
      System.out.println(sq);
    }
}
