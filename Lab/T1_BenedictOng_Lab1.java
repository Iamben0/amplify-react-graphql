import java.util.Scanner;

public class T1_BenedictOng_Lab1 {
    public static void main (String [] args) {
        // Create new scanner object
        Scanner input = new Scanner(System.in);   
        
        //Prompt user to input data        
        System.out.println("Please enter employee Id:");
        String employeeId = input.next();                   // User to enter ID
        input.nextLine();                                   // Clear input buffer     
        System.out.println("Please enter employee name:");
        String name = input.nextLine();                     // User to enter name
        System.out.println("Please enter hours worked:");
        int hoursWorked = input.nextInt();                  // User to enter hours worked
        System.out.println("Please enter hourly rate:");
        int hourlyRate = input.nextInt();                   // User to enter hourly rate  

        // Create a instance for weekly pay
        WeeklyPay w1 = new WeeklyPay(employeeId, name, hoursWorked, hourlyRate);  

        // Prints the toString() method
        System.out.println(w1.toString());  
    }
}

class WeeklyPay {
    // Instance variables to store required information
    private String employeeId;
    private String name;
    private int hoursWorked;
    private int hourlyRate;

    // Other Constructor to receive the four parameters
    public WeeklyPay(String employeeId, String name, int hoursWorked, int hourlyRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    
    // Instance method to return the total pay of the week
    public double getPay() {
        double getPay;
        if (hoursWorked > 40) {
            int hoursWorkedOT = hoursWorked - 40;
            getPay = (hoursWorkedOT * hourlyRate * 2) 
                    + (40 * hourlyRate);
        } 
        else 
            getPay = (hoursWorked * hourlyRate);
        
        return getPay;
    }

    // Instance method to return the String as shown in the program executions 
    public String toString() {
        return employeeId + " " + name + " " + "$" + getPay();
    }

}


