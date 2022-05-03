// This example is to explain: overridden method
// Same method defined in the super class and subclass
// Overridden is different from overload 

public class L4AboutPolymorphism {
    public static void main(String [] args) {
        aboutOverriddenMethod();
        //aboutPolymorphism();
    }

    public static void aboutPolymorphism() {
        L4MyBase something = new L4MyBase(10);
        System.out.println("Test base class instance");
        something.method1();
        something.method2();
        something.method3();
        
        // Base class reference but subclass instance
        // instance of a sub class is also in a base class
        System.out.println("Test subclass instance");
        something = new L4MySub(-99, 200);
        something.method1();
        something.method2();
        something.method3();

        // Cannot call subclass methods when using base class reference
        //something.method4();    // Not allowed

        // Cast a reference to a sub class reference
        // so that we can call methods defined in subclass
        L4MySub anotherRef = (L4MySub)something;        
        anotherRef.method4();
        
    }

    public static void aboutOverriddenMethod() {
        L4MyBase bRef = new L4MyBase(1);
        // all method behave as expected
        bRef.method1();
        bRef.method2();
        bRef.method3();
        
        // Test subclass instance
        System.out.println("Test subclass instance");
        L4MySub sRef = new L4MySub(10, 100);
        sRef.method1();
        sRef.method2();
        sRef.method3();
        sRef.method4();
    }
}

// Base class with some methods
class L4MyBase {
    private int bValue;

    public L4MyBase(int param) {
        bValue = param;
    }

    public void method1() {
        System.out.println("Based method1");
    }
    
    public void method2() {
        System.out.println("Based method2");
    }

    public void method3() {
        System.out.println("Based method3");
    }

    public String toString() {
        return "Base class" + bValue;
    }
}

// Subclass to overwrite some methods in the base class
class L4MySub extends L4MyBase {
    private int sValue;

    public L4MySub(int bParam, int sParam) {
        super(bParam);
        sValue = sParam;
    }

    // Overrides (redefines) some methods in the base class
    @Override // like a annotation/documentation, will still work if doesnt declare this
    public void method2() {
        System.out.println("Subclass method2");
    }

    //Overrides another method
    public void method3() {
        // Can call basee class if neccessary
        System.out.println("Subclass method3 begin");
        super.method3();
        System.out.println("Subclass method3 end");
    }

    // New method in subclass
    public void method4() {
        // Can call instance methods of this class
        // and the super class
        System.out.println("Subclass method4 begin");
        super.method2();
        method2();
        System.out.println("subclass method4 end");
    }
}

/*
public class A {}
public class B extends A {}
public class C extends B {}
public class D extends B {}
 
public class Z extends D {...}
*/