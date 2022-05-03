// About calling overridden method
public class L5AboutCallingMethod {
    public static void main(String[] args) {
        L5MyBase bRef = new L5MyBase();
        bRef.method1();
        bRef.method2();

        // Testing subclass now
        System.out.println("Testing subclass instance");
        L5MySub sRef = new L5MySub();
        sRef.method1();
        sRef.method2();
    }
    
}

class L5MyBase {
    public void method1() {
        System.out.println("Base class method 1");
        method2();
    }

    public void method2() {
        System.out.println("Base class method 2");
    }
}

class L5MySub extends L5MyBase{
    @Override
    public void method2() {
        System.out.println("Subclass method 2");
    }
}


