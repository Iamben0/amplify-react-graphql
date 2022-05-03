import java.util.ArrayList;

public class WeeklyClaimTest {
    public static void main(String[] args) {
        //example1();
        example2();
    }

    public static void example1() {
        WeeklyClaim claim = new WeeklyClaimSS("E1", 10, 10, 100);
        System.out.println(claim.getPay());
        // Attempt to call the method in subclass
        // System.out.println(claim.getTptClaim());   // Error
        // Must downcast reference to subclass 
        WeeklyClaimSS temp = (WeeklyClaimSS)claim;
        System.out.println(temp.getTptClaim());

        // Another instance
        claim = new WeeklyClaim("E2", 10, 10);
        System.out.println(claim.getPay());

    }

    public static void example2() {
        ArrayList<WeeklyClaim> allClaims = new ArrayList<>();
        // Hard code few instances
        allClaims.add(new WeeklyClaim("E1", 10, 10));
        allClaims.add(new WeeklyClaim("E2", 20, 20));
        allClaims.add(new WeeklyClaimSS("E3", 20, 20, 100));
        allClaims.add(new WeeklyClaimSS("E4", 20, 30, 100));
        
        // Print all employess
        for (int x = 0; x < allClaims.size(); x++) {
            System.out.println(allClaims.get(x).getPay());
        }

        //Print all subclass instance
        for (WeeklyClaim wc: allClaims) {
            if (wc instanceof WeeklyClaimSS)      // check if its a subclass  
                System.out.println(wc.getPay());
        }

        // Sum tpt claim of all SS employees
        double totalTpt = 0;
        for (WeeklyClaim oneClaim : allClaims) {
            if (oneClaim instanceof WeeklyClaimSS) {
                // Downcast to subclass references so that we can call method defined in the subclass
                WeeklyClaimSS temp  = (WeeklyClaimSS) oneClaim;
                totalTpt = totalTpt + temp.getTptClaim();
            }
        }
        System.out.println("Total Tpt claim is " + totalTpt);
        // Printing instance
        for (WeeklyClaim ref : allClaims) {
            System.out.println(ref.toString());
        }
    }
}
