import java.util.Scanner;

public class L1Example2 {
    public static void main(String [] itIsJustAName) {
        StringBuffer msg = new StringBuffer("Hello");
        changeMsg(msg);
        // Check the value of msg
        System.out.println(msg);
    }

    // To show that an instance can be passed into an method and modified within the method
    public static void changeMsg(StringBuffer data) {
        // Put in statement to modify data
        Scanner input = new Scanner(System.in);     // System.in is the keyboard
        while (true) {
            System.out.println("Enter a string (empty string to end): ");
            String inputMsg = input.nextLine();     // Read one line from keyboard
            if (inputMsg.length() == 0) 
                break;                              // Stop the loop NOT the if statement    
            // Append user input to data (the StringBuffer)
            data.append(inputMsg);
        }
    }
}