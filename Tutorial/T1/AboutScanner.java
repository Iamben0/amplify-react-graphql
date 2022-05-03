import java.util.Scanner;

public class AboutScanner {
    public static void main(String[] args) {
        aboutNextLineAndLoop();
    }

    public static void aboutNextLineAndLoop() {
        Scanner kboard = new Scanner(System.in);
        int qty = 0;
 
        while (true) {
            System.out.println("Name?");
            String name = kboard.nextLine();

            System.out.println("Quantity?");
            qty = kboard.nextInt();
            if (qty <= 0)
                break;
            System.out.println("Price?");
            double price = kboard.nextDouble();
            kboard.nextLine();

            System.out.println(name);           
            System.out.println(qty);
            System.out.println(price);
        }
    }
    public static void aboutNextLine() {
        Scanner kboard = new Scanner(System.in);
        System.out.println("Quantity?");
        int qty = kboard.nextInt();
        
        System.out.println("Price?");
        double price = kboard.nextDouble();
        kboard.nextLine();

        System.out.println("Name?");
        String name = kboard.nextLine();     // nextLine() works for a single mulitple input

        double totalPrice = qty * price;
        System.out.println(qty);
        System.out.println(name);
        System.out.println(totalPrice);
    }

    public static void aboutNext() {
        Scanner kboard = new Scanner(System.in);
        System.out.println("Name?");
        String name = kboard.next();        // next() works for single input
        System.out.println(name);
    }
}