import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class T1_BenedictOng_Lab3 {
    // Instance arraylist to store Parcel and Parcel8 instance
    static ArrayList<Parcel> parcelList = new ArrayList<Parcel>();

    // final variable to display line
    final static String line = "------------------------";

    // Private static instance variable
    private static String code;
    private static double length, width, height, weight;
    private static char expressYOrN, longDistance;
    private static int selection;
    
    public static void main(String[] args) {
        getUserInput();
        getSelection();
    }

    public static void getUserInput() {
        Scanner input = new Scanner(System.in);
        for (int x = 0; x < 3; x++) {
            // Input parcel code
            System.out.print("Parcel code: ");
            code = input.next();  

            // Validation to make sure LENGTH is positive and accept numerals only
            do {
                System.out.print("Length: ");
                while (!input.hasNextDouble()) {
                    System.out.println("Please input numbers only.");
                    input.next();                               // To prevent print from looping infinitely in while loop and clear buffer
                } 
                length = input.nextDouble();                    // Input length
            } while (length < 0);
            
            // Validation to make sure WIDTH is positive and accept numerals only
            do {
                System.out.print("Width: ");
                while (!input.hasNextDouble()) {
                    System.out.println("Please input numbers only.");
                    input.next();                               
                }
                width = input.nextDouble();                     // Input width
            } while (width < 0);

            // Validation to make sure HEIGHT is positive and accept numerals only
            do {
                System.out.print("Height: ");
                while (!input.hasNextDouble()) {
                    System.out.println("Please input numbers only.");
                    input.next();                                
                }
                height = input.nextDouble();                     // Input height
            } while (height < 0);

            // Validation to make sure WEIGHT is positive and accept numerals only
            do {
                System.out.print("Weight: ");
                while (!input.hasNextDouble()) {
                    System.out.println("Please input numbers only.");
                    input.next();                                 
                }
                weight = input.nextDouble();                    // Input weight
            } while (weight < 0);
                
            System.out.print("Express (y/n)? ");             
            expressYOrN = input.next().charAt(0);
            input.nextLine();                                   // Clear input buffer

            //'y'/'Y' for express, 'n'/'N' for not express
            if ((expressYOrN == 'y') || (expressYOrN == 'Y')) {
                System.out.print("Long distance (y/n)? ");    
                longDistance = input.next().charAt(0);
                input.nextLine();                               // Clear input buffer

                // Create a Parcel8 (subclass) instance using Parcel (superlcass) reference
                Parcel p = new Parcel8(code, length, width, height, weight, longDistance);      // Upcasting
                // Add instance Parcel in Parcel ArrayList
                parcelList.add(p);                                 
            } else {
                // Create instance for Parcel
                Parcel p = new Parcel(code, length, width, height, weight);    
                // Add instance Parcel in Parcel ArrayList
                parcelList.add(p);
            }
            System.out.println(line);
        }
    }

    public static void getSelection() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1 Show all items");
            System.out.println("2 Show express items");
            System.out.println("3 Quit");
            System.out.print("Your selection: ");
                
            selection = input.nextInt();                        // Input for selection
            input.nextLine();                                   // Clear Input buffer
            System.out.println();
            switch(selection) {
                case 1 ://System.out.println("Your selection: " + selection);
                        // Show parcel instance in parceList
                        for (Parcel p1 : parcelList)
                            System.out.println(p1.toString());
                        break;
                case 2 ://System.out.println("Your selection: " + selection);
                        for (Parcel p1 : parcelList) {
                            if (p1 instanceof Parcel8) {        
                                Parcel8 temp = (Parcel8)p1;     // Downcasting
                                System.out.println((temp.toString()));
                            }
                        }
                        break;
                case 3 :System.out.println("Quit");
                        break;
                default:System.out.println("Please enter 1, 2 or 3 only.\n");
            }
        } while (selection != 3);
    }
}

// Superclass
class Parcel {
    private static double baseFee = 3;
    // Instance variables
    private String code;
    private double length, width, height;
    private double weight;
    
    // Constructor
    public Parcel(String code, double length, double width, double height, double weight) {
        this.code = code;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }    

    // Getters
    public String getCode() {
        return code.toUpperCase();
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    // Setters
    public void setCode(String code) {
        this.code = code;
    }

    public void setLength(double length) {
        if (length > 0)                   // validation
            this.length = length;
    }

    public void setWidth(double width) {
        if (width > 0)                   // validation
            this.width = width;    
    }

    public void setHeight(double height) {
        if (height > 0)                   // validation
            this.height = height;
    }

    public void setWeight(double weight) {
        if (weight > 0)                   // validation
            this.weight = weight;
    }
    // Get volume method
    public int getVolume() {
        int volume = (int) (length * width * height);
        return volume;
    }

    // Get volumetric weight method
    public double getVolumetricWeight() {
        return (double) getVolume() / 5000;
    }

    // Get delivery fees based on the weight OR vol weight
    public double getFee() {
        double heaviest;

        // Find the heaviest weight between vol weight vs weight
        if (getVolumetricWeight() > weight) 
            heaviest = getVolumetricWeight();
        else
            heaviest = weight;

        // if weight is more than 1kg, 
        // return $1 for every 1kg (after deducting the first kg) + $3 (base fee based on first kg)
        if (heaviest > 1) {
                return (Math.ceil((heaviest - 1)) + baseFee); 
            } else {
                return baseFee; 
        }
    }
    
    // Print code + fees + vol weight + weight 
    public String toString() {
        DecimalFormat twoDP = new DecimalFormat("#0.00");   // print double variables to 2 dp place
        return "Parcel code: " + getCode() + "\n" +
                "Delivery fees: $" + twoDP.format(getFee()) + "\n" +
                "Volumetric weight: " + getVolumetricWeight() + "kg" + "\n" +
                "Weight: " + weight + "kg" + "\n";
    } 
}


// Subclass
class Parcel8 extends Parcel {
    private char longDistance;

    public Parcel8(String code, double length, double width, double height, double weight, char longDistance) {
        super(code, length, width, height, weight);
        this.longDistance = longDistance;
    }

    // Getter
    public char getLongDistance() {
        return longDistance;
    }

    // Override getFee and getString method
    @Override
    public double getFee() {
        if ((longDistance == 'y') || (longDistance == 'Y')) {   
            return (super.getFee() + (super.getFee() * 0.35));   // Express delivery fees
        } else {
            return (super.getFee() + (super.getFee() * 0.2));  // Express delivery + long distance fees
        }
    }

    @Override
    // Print express + code + fees + vol weight + weight
    public String toString() {
        return "Express" + "\n" +
                "Long Distance: " + Character.toUpperCase(getLongDistance()) + "\n" +
                super.toString();
    }
}