public class L3InheritanceMethod {
    public static void main(String [] args) {
        L3MyBase1 bRef = new L3MyBase1();
        bRef.bMethod();
        //bRef.sMethod(); // Subclass method no usable here
        // Test subclass instance
        System.out.println("Test subclass instance");
        L3MySub1 sRef = new L3MySub1();
        sRef.bMethod();
        sRef.sMethod();
        //sRef.pMethod();  // Private method not usable in subclass

        // Test subclass of subclass
        System.out.println("Test subclass of subclass");
        L3MySubSub1 ssRef = new L3MySubSub1();
        ssRef.bMethod();
        ssRef.sMethod();
        ssRef.ssMethod();
    }
}

// Public method defined in the base(super) class will be 
// passed down to the sub class
class L3MyBase1 {
    public void bMethod() {
        System.out.println("bMthod");
    }

    // Private method are not pass down, only public 
    private void pMethod() {
        System.out.println("private method");
    }
}

// Subclass
class L3MySub1 extends L3MyBase1 {
    public void sMethod() {
        System.out.println("sMethod");
    }
}

class L3MySubSub1 extends L3MySub1 {
    public void ssMethod() {
        System.out.println("ssMethod");
    }
}

