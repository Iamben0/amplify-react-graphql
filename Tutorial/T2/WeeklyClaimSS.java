public class WeeklyClaimSS extends WeeklyClaim {
    private static double SUB_PER_KM = 0.2;
    private int distance;

    public WeeklyClaimSS(String id, int hoursWorked, double hourlyRate, int distance) {
        super(id, hoursWorked, hourlyRate);
        this.distance = distance;
    }

    public double getTptClaim() {
        return distance * SUB_PER_KM;
    }
    
    @Override
    public double getPay() {
        return super.getPay() + getTptClaim();
    }

    @Override
    public String toString() {
        return super.toString() + 
            " with tpt claim = " + 
            getTptClaim();
    }
}
