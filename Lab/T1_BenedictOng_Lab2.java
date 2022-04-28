import java.util.Arrays;
import java.util.Scanner;

public class T1_BenedictOng_Lab2 {
    public static void main (String[] args) {
        // Declare and initialise Container array 
        Cylinder[] container = new Cylinder[5];

        setUserInput(container);
        getTypeOrVolume(container);
    }
       
    // User input data 5 times
    public static void setUserInput(Cylinder[] container) {
        // Create a scanner instance
        Scanner input = new Scanner(System.in);        
        for (int x = 0; x < 5; x++) {
            System.out.print("Container type: ");
            String type = input.nextLine();                // User to input type of Cylinder
            System.out.print("Radius: ");
            double radius = input.nextDouble();            // User to input radius
            System.out.print("Height: ");
            double height = input.nextDouble();            // User to input height
            input.nextLine();                              // Clear input buffer        
            // Store cylinder object in Container array 
            container[x] = new Cylinder(type, radius, height);
        }
        System.out.println();
    }

    // User to search by type or volume
    public static void getTypeOrVolume(Cylinder[] container) {
        // Create a scanner instance
        Scanner input = new Scanner(System.in); 
        int option;
        do {
            System.out.println("Container Search: ");
            System.out.println("1 By type");
            System.out.println("2 By Volume");
            System.out.println("3 Quit");
            System.out.println("Your selection?");
            option = input.nextInt();
            System.out.println();
            input.nextLine();                              // Clear input buffer 

            if (option == 1) {
                System.out.print("Enter type: ");       // By type
                String types = input.nextLine();
                for (Cylinder c: container) {
                    if (types.equals(c.getType())) 
                        System.out.println(c);
                }
                System.out.println();
            }
            else if (option == 2) {                        // By Volume 
                System.out.print("Enter Volume: ");
                double volume = input.nextInt();
                for (Cylinder c: container) {
                    if (c.getVolume() >= volume) 
                        System.out.println(c);
                }
                System.out.println();
            }
            else if (option == 3) {
                System.out.println("Quit");
            }
            else {
                System.out.println("Please select the option 1, 2 or 3 only");
            }
        } while (option != 3);
    }   
} 

class Cylinder {
    // Instance variables to store required information
    private String type;
    private double radius;
    private double height;

    // Constructor to receive and initialised the three parameters
    public Cylinder (String type, double radius, double height) {
        this.type = type;
        this.radius = radius;
        this.height = height;
    }

    // Getters for type, radius and height
    public String getType() {
        return type;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    // Return total volume for a cylinder
    public int getVolume() {
        int totalVolume = (int) (((Math.PI) * radius * radius * height) + 0.5);      // + 0.5 to round up
        return totalVolume;
    } 

    // Instance method to print a string when program execute
    public String toString() {
        return type + " container with volume " + getVolume();
    }
}