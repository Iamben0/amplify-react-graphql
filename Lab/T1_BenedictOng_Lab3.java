import java.util.ArrayList;
import java.util.Scanner;

public class T1_BenedictOng_Lab3 {
    // Instance arraylist to store Parcel and Parcel8 instance
    static ArrayList<Parcel> parcelList = new ArrayList<Parcel>();

    // final variable to display line
    final static String line = "------------------------";

    // Private static instance variable
    private static String code;
    private static double length, width, height, weight;
    private static char expressYOrN, longDistance;
    private static int option;
    
    public static void main(String[] args) {
        getUserInput();
        getOptions();
    }

    public static void getUserInput() {
        Scanner input = new Scanner(System.in);
        for (int x = 0; x < 3; x++) {
            System.out.print("Parcel code: ");
            code = input.nextLine();                            // Input parcel code
            System.out.print("Length: ");
            length = input.nextDouble();                        // Input length
            System.out.print("Width: ");
            width = input.nextDouble();                         // Input width
            System.out.print("Height: ");
            height = input.nextDouble();                        // Input height
            System.out.print("Weight: ");
            weight = input.nextDouble();                        // Input weight
            input.nextLine();                                   // Clear input buffer
            System.out.print("Express (y/n)? ");             // Input y/n for express
            expressYOrN = input.next().charAt(0);
            input.nextLine();                                   // Clear input buffer

            if ((expressYOrN == 'y') || (expressYOrN == 'Y')) {
                System.out.print("Long distance (y/n)? ");    // Input y/n for long distance
                longDistance = input.next().charAt(0);
                input.nextLine();                                      // Clear input buffer

                /*// Create instance for Parcel8
                Parcel8 p8 = new Parcel8(code, length, width, height, weight, longDistance);
                // Add instance Parcel8 in Parcel ArrayList
                parcelList.add(p8);*/

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

    public static void getOptions() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1 Show all items");
            System.out.println("2 Show express items");
            System.out.println("3 Quit");
            System.out.print("Your selection: ");
                
            option = input.nextInt();                           // Input for option
            input.nextLine();                                   // Clear Input buffer
            switch(option) {
                case 1 :System.out.println("\nYour selection: " + option);
                    // Show parcel instance in parceList
                        for (Parcel p1 : parcelList)
                            System.out.println(p1.toString());
                        //System.out.println(line);
                        break;
                case 2 :System.out.println("\nYour selection: " + option);
                        for (Parcel p1 : parcelList) {
                            if (p1 instanceof Parcel8) {        
                                Parcel8 temp = (Parcel8)p1;     // downcasting
                                System.out.println((temp.toString()));
                            }
                        //System.out.println(line);
                        }
                        break;
                case 3 :System.out.println("Quit");
                        break;
                default:System.out.println("Please enter 1, 2 or 3 only.\n");
            }
        } while (option != 3);
    }
}

// Superclass
class Parcel {
        // Instance variables
        String code;
        double length, width, height;
        double weight;
    
    
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

        // Get volume method
        public int getVolume() {
            int volume = (int) (length * width * height);
            return volume;
        }

        // Get volumetric weight method
        public int getVolumetricWeight() {
            int volWeight = getVolume() / 5000;
            return volWeight;
        }

        // Get delivery fees based on the weight OR vol weight
        public double getFee() {
            double heaviest;

            // Find the heaviest weight between vol weight vs weight
            if (getVolumetricWeight() > weight) 
                heaviest = getVolumetricWeight();
            else
                heaviest = weight;

            if (heaviest > 1) {
                    return (Math.ceil((heaviest - 1)) + 3); 
                } else {
                    return 3; 
            }
        }

        public String toString() {
            return code + " $" + getFee();
        }
}

// Subclass
class Parcel8 extends Parcel {
    char longDistance;

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
    public String toString() {
        return "Express " + super.getCode() + " $" + getFee();
    }
}