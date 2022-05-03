public class L3InheritanceVariable {
    public static void main(String [] args) {
        //test1();
        test2();
    }

    public static void test1() {
        L3MySub2 sRef = new L3MySub2();     // by creating new instance, JVM will call L3MySub2 default constructor
        System.out.println(sRef.getBValue());
        System.out.println(sRef.getSValue());
    }

    public static void test2() {
        L3MySub3 sRef = new L3MySub3(10);
        System.out.println("Check instance variables");
        System.out.println(sRef.getBValue());
        System.out.println(sRef.getSValue());

        // Create instance of subclass using different
        // constructor
    System.out.println("Test another constructor");
        L3MySub3 sRef2 = new L3MySub3(10, 100);
        System.out.println("Check instance variables again");
        System.out.println(sRef2.getBValue());
        System.out.println(sRef2.getSValue());
    }
}

// Another base class and subclass but similar to the previous classes
class L3MyBase3 {
    private int bValue;

    public L3MyBase3() {
        System.out.println("Base class default constructor");
    }

    public L3MyBase3(int bParam) {
        bValue = bParam;
    }
    
    public int getBValue() {
        return bValue;
    }
}

class L3MySub3 extends L3MyBase3{
    private int sValue;
    
    public L3MySub3(int sParam) {
        sValue = sParam;
    }

    public L3MySub3(int sParam, int bParam) {
        super(bParam);
        sValue = sParam;
    }

    public int getSValue() {
        return sValue;
    }
}
/////////////////////////////////////////////////////////////////////

// All instance variables defined in the base class will be
// included in an instance of the subclass.
// Private instance variables remain as private (inaccessible)
// even when they are included in the sub-class instance.
class L3MyBase2 {
    private int bValue;

    public L3MyBase2() {
        System.out.println("L3MyBase2() method is called");
        bValue = -99;
    }

    public int getBValue() {
        return bValue;
    }
}

// Subclass
class L3MySub2 extends L3MyBase2 {
    private int sValue;

    // if no constructor is at defined in the class, it will call on 
    // the dafault constructor + the parent class (super()) default constructor
    /*public L3MtSub2() {
        super();        // (L3MyBase2)parent class default constructor
    }
    */

    public L3MySub2() {
        //super();        // will create by JVM even though we nvr create to call on L3MyBase2 constructor first
        System.out.println("L3MySub2() is caleed");
        sValue = 1999;
    }

    public int getSValue() {
        return sValue;
    }
}

