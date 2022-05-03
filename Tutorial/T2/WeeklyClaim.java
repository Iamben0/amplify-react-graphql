public class WeeklyClaim {
    private static int ELEMENT = 40;
    private String id;
    private int hoursWorked;
    private double hourlyRate;

    public WeeklyClaim(String id, int hoursWorked, double hourlyRate) {
        this.id = id;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Setters
    public void setHoursWorked(int newValue) {
        if (newValue > 0)                   // need to have validation
            hoursWorked = newValue;
    }

    public double getPay() {
        if (hoursWorked <= ELEMENT) {
            return hoursWorked * hourlyRate;
        }
        else {
            double otPay = (hoursWorked - ELEMENT) * hourlyRate * 2;
            return otPay + (ELEMENT * hourlyRate);
        }
    }

    @Override
    public String toString() {
        return id + " with pay = " + getPay();
    }
}
