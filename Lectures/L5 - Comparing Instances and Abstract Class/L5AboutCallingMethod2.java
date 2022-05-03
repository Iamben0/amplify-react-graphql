public class L5AboutCallingMethod2 {
    public static void main(String[] args) {
        L5DataAnalysis rainFall = new L5DataAnalysis(12);
        rainFall.update(0,124);
        System.out.println(rainFall.getValue(0));

        // Testing subclass
        L5EnrolmentAnalysis uowQ1 = new L5EnrolmentAnalysis(50);
        uowQ1.update(0, 200);
        System.err.println(uowQ1.getValue(0));


    }
}

class L5DataAnalysis {
    private double [] data;

    // Many other isntance variables
    public L5DataAnalysis(int dataSize) {
        initialise(dataSize);
        // Plus other statmements to do ...
        System.out.println("Base class constructor");
    }

    // previously is public
    private void initialise(int dataSize) {
        data = new double[dataSize];
        // Other statement to initialise other thing
        System.out.println("Base class initialised");
    }

    public void update (int index, double measurement) {
        data[index] = measurement;
    }

    public double getValue(int index) {
        return data[index];
    }

    // Other useful methods to calculate various things...
}

class L5EnrolmentAnalysis extends L5DataAnalysis {
    private double [] result;

    public L5EnrolmentAnalysis(int enrolSize) {
        super(enrolSize);
        initialise(enrolSize);
        System.out.println("Subclass constructor");
    }

    public void initialise(int enrolSize) {
        result = new double[enrolSize];
        // Other statements to initialise other things
        System.out.println("Subclass initialise");
    }

    // Other methods to calculate/analyse enrolment data
}