import java.util.ArrayList;

public class L5AbstractClassExample2 {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1() {
        // using superclass ref
        L5Result r1 = new L5ResultWritten("C1", "Alice", 100, 100);
        System.out.println(r1.getOverallScore());
        System.out.println(r1.getGrade());

        // using subclass ref
        L5ResultWritten r2 = new L5ResultWritten("C1", "Alice", 100, 100);
        System.out.println(r2.getOverallScore());
        System.out.println(r2.getGrade());
        System.out.println(r2.getEssayScore()); 

        // Another subclass 
        r1 = new L5ResultPresentation("C3", "Mark", 40, 90);
        System.out.println(r1.getOverallScore());
        System.out.println(r1.getGrade());
    }

    public static void test2() {
        ArrayList<L5Result> results = new ArrayList<>();
        results.add(new L5ResultWritten("C1", "Alice", 50, 50));
        results.add(new L5ResultPresentation("C2", "Mark", 50, 70));

        for (L5Result r : results) {
            System.out.println(r.getOverallScore() + " " + 
                               r.getGrade());
        }
    }
}

// Abstact superclass
abstract class L5Result {
    private String id;
    private String name;

    public L5Result(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // all the sub class for L5Result(Superclass) must overwrite this method cos abstract (no implemetation {})
    public abstract double getOverallScore();

    public String getGrade() {
        double finalScore = getOverallScore();
        if (finalScore < 50)
            return "Fail";
        else if (finalScore < 65)        
            return "Pass";
        else if (finalScore < 70)
            return "Credit";
        else if (finalScore < 85)
            return "Distinction";
        else 
            return "HD";
    }
}

// Sub class
class L5ResultWritten extends L5Result {
    private double essayScore;
    private double refScore;

    public L5ResultWritten(String id, String name, double essayScore, double refScore) {
        super(id, name);
        this.essayScore = essayScore;
        this.refScore = refScore;
    }

    // Get and Set methods
    public double getEssayScore() {
        return essayScore;
    }

    public double getRefScore() {
        return refScore;
    }

    public void setEssayScore(double essayScore) {
        if (essayScore >= 0) {
            this.essayScore = essayScore;
        }
    } 

    @Override
    public double getOverallScore() {
        return (essayScore * 0.8) + (refScore * 0.2);
    }
}

// Sub class
class L5ResultPresentation extends L5Result {
    private double score1, score2;

    public L5ResultPresentation(String id, String name, double score1, double score2) {
        super(id, name);
        this.score1 = score1;
        this.score2 = score2;
    }

    // get and set methods
    public double getScore1() {
        return score1;
    }

    @Override
    public double getOverallScore() {
        if (score1 < 50 || score2 < 50) 
            return 0;
        else if (score1 > score2)
            return score1;
        else 
            return score2;
    }
}


