import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class T1_BenedictOng_A2 {
    // Instance arraylist to store ToyCar and ElectricToyCar instance
    static ArrayList<ToyCar> inventoryList = new ArrayList<ToyCar>();

    // final variable to display line
    final static String line = "----------------------------------------------------";

    // Private static instance variable
    private static String modelCode;
    private static int quantity, batteryDuration, chargingDuration;
    private static double price;
    private static int option;

    public static void main(String[] args) {
        getOptions();
    }

    public static void getOptions() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1 Add inventory");
            System.out.println("2 Remove inventory");
            System.out.println("3 Show all inventory by car model");
            System.out.println("4 Search inventory by car model");
            System.out.println("5 Search inventory by car price");
            System.out.println("6 Search inventory by car battery duration");
            System.out.println("7 Quit");
            System.out.print("Your selection: ");
                   
            option = input.nextInt();                           // Input for option
            input.nextLine();                                   // Clear Input buffer
            System.out.println(line);
            if (option == 1) {
                System.out.println("1 Ordinary Toy Car (OTC-XXX)");
                System.out.println("2 Electric Toy Car (ETC-XXX)");
                System.out.print("Your Selection: ");
                // int selection;
                // do {
                //     System.out.println("1 Ordinary Toy Car (OTC-XXX)");
                //     System.out.println("2 Electric Toy Car (ETC-XXX)");
                //     System.out.print("Your Selection: ");                        
                //     while (!input.hasNextInt()) {
                //         System.out.println("Please select 1 or 2 only.");
                //         System.out.println(line);
                //         input.next();                               // To prevent print from looping infinitely in while loop and clear buffer
                //     } 
                //     selection = input.nextInt();                    // Input selection
                // } while (selection < 0);
                
                int selection = input.nextInt();                    
                System.out.print(line);
                input.nextLine();                                    // Clear Input buffer
                // get input for Ordinary Toy Car
                if (selection == 1) {
                    System.out.print("\nModel Code: ");           // get input for Ordinary Toy Car 
                    modelCode = input.next();


                    /*                    
                    // Validation to make sure PRICE is positive and accept numerals only            
                    do {
                        System.out.print("Price: ");                        
                        while (!input.hasNextDouble()) {
                            System.out.println("Please input numbers only.");
                            input.next();                               // To prevent print from looping infinitely in while loop and clear buffer
                        } 
                        price = input.nextDouble();                    // Input price
                    } while (price < 0);

                    // Validation to make sure QUANTITY is positive/0 and accept numerals only      
                    do {
                        System.out.print("Quantity: ");                        
                        while (!input.hasNextDouble()) {
                            System.out.println("Please input numbers only.");
                            input.next();                               
                        } 
                        quantity = input.nextDouble();                    // Input quantity
                    } while (price <= 0);
                    */


                    System.out.print("Price: ");
                    price = input.nextDouble();
                    input.nextLine();                                // Clear Input buffer
                    if (price <= 0) {
                        System.out.println("Price must be more than 0. Please try again.");
                        System.out.println(line);
                    }
                    else {
                        System.out.print("Quantity: ");
                        quantity = input.nextInt();
                        input.nextLine();                                // Clear Input buffer
                        
                        if (quantity < 0) {
                            System.out.println("Quantity cannot be less than 0. Please try again.");
                            System.out.println(line);
                        } else {
                            System.out.println(line);
                            boolean exists = false;
                            for (ToyCar tc : inventoryList) {
                                if (tc.getModelCode().equals(modelCode)) {   // if input model code equals to instance's model code, return true
                                    exists = true;
                                }
                            }
                            if (exists == false) {                           // if return is false, add instances into arraylist
                                ToyCar ordinaryTC = new ToyCar(modelCode, price, quantity);
                                inventoryList.add(ordinaryTC);
                            } else {                                         // if return is true, display message
                                System.out.println("Duplicated model code found. Please try again.");
                                System.out.println(line);
                            }                   
                        }
                    }
                } 
                else if (selection == 2) {                           
                    System.out.print("\nModel Code: ");           // get input for Eletric Toy Car 
                    modelCode = input.next();

                    System.out.print("Price: ");
                    price = input.nextDouble();
                    input.nextLine();                                // Clear Input buffer

                    System.out.print("Quantity: ");
                    quantity = input.nextInt();
                    input.nextLine();                                // Clear Input buffer

                    System.out.print("Battery Duration: ");
                    batteryDuration = input.nextInt();
                    input.nextLine();                                // Clear Input buffer

                    System.out.print("Charging Duration: ");
                    chargingDuration = input.nextInt();
                    input.nextLine();                                // Clear Input buffer
                    System.out.println(line);

                    boolean exists = false;
                    for (ToyCar tc : inventoryList) {
                        if (modelCode.equals(tc.getModelCode())) {   // if input model code equals to instance's model code, return true
                            exists = true;
                        }
                    }
                    if (exists == false) {                           // if return is false, add instances into arraylist
                        ToyCar eletricTC = new ToyCarElect(modelCode, price, quantity, batteryDuration, chargingDuration);
                        inventoryList.add(eletricTC);
                    } else {                                         // if return is true, display message
                        System.out.println("Duplicated model code found. Please try again.");
                        System.out.println(line);
                    }
                } else {
                    System.out.println("\nPlease select 1 or 2 only.");
                    System.out.println(line);
                }
            } 
            else if (option == 2) {
                System.out.print("Model Code: ");   
                modelCode = input.next();
                boolean exists = false;

                for (int x = 0; x < inventoryList.size(); x++) {
                    if (modelCode.equals(inventoryList.get(x).getModelCode())) {
                        exists = true;
                        if (inventoryList.get(x).getQuantity() == 0) {      // if instance quantity = 0, remove ID
                            inventoryList.remove(x);
                            System.out.println("ID removed.");
                            System.out.println(line);
                        } else {                                            // if return is true but quanity > 0, display message
                            System.out.println("Quantity is not zero, hence not able to remove.");
                            System.out.println(line);
                        }
                    }
                }   
                // does not exist in arraylist
                if (exists == false) {                               
                	System.out.println("Model ID does not exists.");
                    System.out.println(line);
                }
            } 
            else if (option == 3) {
                for (ToyCar tc : inventoryList) {
                    System.out.println(tc);
                    System.out.println();
                }
                System.out.println(line);
            }
            else if (option == 4) {
                System.out.print("Model Code: ");  
                modelCode = input.next();
                System.out.println();
                boolean matchModel = false;
                for (ToyCar tc : inventoryList) {
                    if (modelCode.equals(tc.getModelCode())) {
                        matchModel = true;
                        System.out.println(tc);
                    }
                }
                if (matchModel == false) {
                    System.out.println("No matching Model Code found.");
                }
                System.out.println(line);
            } 
            else if (option == 5) {
                System.out.print("Please enter a lower bound: ");
                int lowerBound = input.nextInt();
                System.out.print("Please enter an upper bound: ");
                int upperBound = input.nextInt();
                boolean noUpperAndLower = true;
                for (ToyCar tc : inventoryList) {
                    if (tc.getPrice() >= lowerBound && tc.getPrice() <= upperBound) {
                        System.out.println(tc.toString());
                        System.out.println();
                        noUpperAndLower = false;
                    }
                }
                System.out.println(line);
                if (noUpperAndLower) {
                    System.out.println("There is no matching model that matches the price.");
                    System.out.println(line);
                }
            } 
            else if (option == 6) {
                System.out.print("Please enter a battery duration: ");
                int batteryValue = input.nextInt();
                boolean noBatteryValue = true;
                for (ToyCar tc : inventoryList) {
                    if (tc instanceof ToyCarElect) { 
                        ToyCarElect temp = (ToyCarElect)tc;         // Downcasting
                        if (temp.getBatteryDuration() >= batteryValue) {
                            System.out.println(tc.toString());
                            System.out.println();
                            noBatteryValue = false;
                        }
                    }
                }
                System.out.println(line);
                if (noBatteryValue) {
                    System.out.println("There is no matching model that matches the battery duration.");
                    System.out.println(line);
                }
            } 
            else if (option == 7) {
                System.out.println("Quit\n");
            } else 
                System.out.println("Please enter 1, 2, 3, 4, 5, 6 or 7 only.\n");
        }
        while (option != 7);
    }
}

class ToyCar {
    // Instance variables
    private String modelCode;
    private double price;
    private int quantity;

    // Constructor
    public ToyCar(String modelCode, double price, int quantity) {
        this.modelCode = modelCode;

        if (price < 0.00)           // validate price
            throw new IllegalArgumentException("Price cannot be negative.");
        this.price = price;
            
        if (quantity < 0)           // validate quantity
            throw new IllegalArgumentException("Quantity cannot be negative.");
        this.quantity = quantity;
    }

    // Getters
    public String getModelCode() {
        return modelCode;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public void setPrice(double price) {
        if (price >= 0.00)               // validation: price can't be negative
            this.price = price;

        /*if (price < 0.00)           // validate price
            throw new IllegalArgumentException("Price cannot be negative.");
        this.price = price;*/
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0)               // validation: quantity can't be negative
            this.quantity = quantity;
        
        /*if (quantity < 0)           // validate quantity
            throw new IllegalArgumentException("Quantity cannot be negative.");
        this.quantity = quantity;*/
            
    }

    // Calulate total inventory worth method
    public double getTotalInvenWorth() {
        return price * (double) quantity;
    }

    // Calculate insurance cost
    public double getInsuranceCost() {
        return 0.02 * getTotalInvenWorth();     //  2% of the total inventory worth
    }

    // Display all information for the model
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.00");   // print double variables to 2 dp place

        return "Model Code: " + getModelCode() + "\n" +
               "Price: $" + df.format(getPrice()) + "\n" +
               "Quantity: " + getQuantity() + "\n" +
               "Total Inventory Worth: $" + df.format(getTotalInvenWorth()) + "\n" +
               "Insurance cost: $" + df.format(getInsuranceCost());
    }
}

class ToyCarElect extends ToyCar {
    private int batteryDuration;
    private int chargingDuration;

    public ToyCarElect(String modelCode, double price, int quantity, int batteryDuration, int chargingDuration) {
        super(modelCode, price, quantity);
        this.batteryDuration = batteryDuration;
        this.chargingDuration = chargingDuration;
    }

    // Getters
    public int getBatteryDuration() {
        return batteryDuration;
    }

    public int getChargingDuration() {
        return chargingDuration;
    }

    // Setters 
    public void setBatteryDuration(int batteryDuration) {
        if (batteryDuration >= 0)               // validation: batteryDuration can't be negative
            this.batteryDuration = batteryDuration;
    }

    public void setChargingDuration(int chargingDuration) {
        if (chargingDuration >= 0)               // validation: chargingDuration can't be negative
            this.chargingDuration = chargingDuration;
    }

    // Override getInsuranceCost method
    @Override
    public double getInsuranceCost() {
        return 0.1 * getTotalInvenWorth();      // 10% of the total inventory worth
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\nBattery Duration: " + getBatteryDuration() + "\n" + 
               "Charging Duration: " + getChargingDuration();
    }
}
