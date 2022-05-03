import java.util.jar.Attributes.Name;

// Very simple example on abstract base class
public class L5AbstractClassExample {
    public static void main(String[] args) {
        //L5Employee e1 = new L5Employee("E1", "Alice");        // cannot create instance of superclass cos it's abstract
        L5FullTimeEmployee e2 = new L5FullTimeEmployee("E2", "John", 3000);
    }
}

// An incomplete class (Baseclass)
abstract class L5Employee {
    private String id;
    private String name;
    // Others ....

    public L5Employee(String eId, String eName) {
        id = eId;
        name = eName;
    }

    // Other useful methods
}

// A concrete subclass
class L5FullTimeEmployee extends L5Employee {
    private double salary;

    public L5FullTimeEmployee(String eId, String eName, double eSalary) {
        super(eId, eName);
        salary = eSalary;
    }

    // Other methods can be added to the subclass
}




