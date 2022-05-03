public class L1Example1 {
    public static void main(String [] anyNameIsFine) {
        exploreInstanceAndMethod();
        //exploreString();
        System.out.println("End of Program");
    }

    public static void exploreString() {
        // String is immutable. That means an instance of String CANNOT be changed.
        
        String s1 = "abc";              // s1 pointing to a memory location - an instance of abc
        String s2 = s1;                 // s2 another reference, pointing to the same instance s1 is pointing to
                                        // We have to refernces but only 1 instance
        System.out.println(s1 == s2);   // true , because s1 and s2 are refering to the same memory location
        
        // Now we try to change the instance
        s1 = s1.toUpperCase();
        System.out.println(s1);         // "ABC"
        System.out.println(s2);         // "abc"
        System.out.println(s1 == s2);   // false 

        // Another example 
        String s3 = "Hello Java";
        s3 = s3.toUpperCase();
        System.out.println(s3);         // "HELLO JAVA"
        
        String s4 = "Use it";
        System.out.println(s4.toUpperCase());   // "USE IT"
        System.out.println(s4);                 // "Use it"
        // new and without new
        String s11 = "Python";
        String s12 = "Python";                  // Point to the same instance as s11
        String s13 = new String("Python");      // Different instance
    
        System.out.println(s11 == s12);         // true
        System.out.println(s11 == s13);         // false
        System.out.println(s12 == s13);         // false
    }

    public static void exploreInstanceAndMethod() {
        StringBuffer msg = new StringBuffer();          // msg is reference
                                                        // new StringBuffer creates an instance
        // Make use of the instance methods defined in StringBuffer (to store multiple characters)
        msg.append("Hello");
        msg.append(12345);
        // Let's check the result
        System.out.println(msg.length());
        System.out.println(msg.charAt(1));
        System.out.println(msg.toString());             // "Hello12345" 
        System.out.println(msg);                        // "Hello12345" 

        // More instance methods
        System.out.println(msg.indexOf("e"));           // return the position of character "e"
        System.out.println(msg.substring(1, 3));        // return the characters from index 1 to 3

        // Another instance 
        StringBuffer names = new StringBuffer();
        names.append("Alice");
        names.append(", ");
        names.append("Benny");
        names.append(", ");
        names.append("Cupcakes".charAt(2));
        System.out.println(names);
    }
}
