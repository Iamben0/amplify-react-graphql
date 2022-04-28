import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

enum Grade {
    Good, Pass, Fail
}

public class T01F_BenedictOng_A1 {

    // Instance arraylist to save the TestResult object
    static ArrayList<TestResult> resultList = new ArrayList<TestResult>();

    // final variable to display line
    final static String line = "------------------------------------------------------------------";

    // Private static instance variable
    private static String id;
    private static String name;
    private static double score1;
    private static double score2;
    private static String yesOrNo;
    private static int option;

    public static void main(String[] args) {
        getUserInput();
        getOptions();
        
    }

    public static void getUserInput() {
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Candidate Id: ");
            id = input.next();                                  // User to enter ID
            input.nextLine();                                   // Clear input buffer
            System.out.print("Name        : ");
            name = input.nextLine();                            // User to enter name
            System.out.print("Test 1 score: ");
            score1 = input.nextDouble();                        // User to enter score1
            System.err.print("Test 2 score: ");
            score2 = input.nextDouble();                        // User to enter score2
            input.nextLine();                                   // Clear input buffer
            System.out.print("Enter another record? (y/n) ");
            yesOrNo = input.nextLine();                         // User to select whether to enter another record
            System.out.println(line);
                        
            // Create new class object
            TestResult tr1 = new TestResult(id, name, score1, score2);
            resultList.add(tr1);
            
        } while (yesOrNo.equals("y") || yesOrNo.equals("Y") ||
                 yesOrNo.equals("Yes") || yesOrNo.equals("yes"));                   // y/Y/yes/YES to continue the loop
    }

    public static void getOptions() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1 Search test result by applicant Id");
            System.out.println("2 Search test result(s) by applicant name");
            System.out.println("3 Search test result(s) by overall score");
            System.out.println("4 Show test result(s) with highest overall score");
            System.out.println("5 Show failure list");
            System.out.println("6 Quit");
            System.out.print("Please choose an option: ");
            option = input.nextInt();
            input.nextLine();                       // Clear input buffer
            System.out.println(line);

            if (option == 1) {
                System.out.println("Please enter application ID: ");
                id = input.nextLine();
                TestResult tr = new TestResult(id, null, 0, 0);
                if (tr.compareResult(tr) == false) {
                    System.out.println("There is no matching result");
                    System.out.println(line);
                }
            }
            else if (option == 2) {
                System.out.println("Please enter name: ");
                name = input.nextLine();
                boolean noName = true;
                for (TestResult tr : resultList) {
                    if (name.equals(tr.getName())) {
                        System.out.println(tr.toString());
                        System.out.println(line);
                        noName = false;
                    }
                }
                if (noName) {
                    System.out.println("There is no matching result");
                    System.out.println(line);
                    }
            }
            else if (option == 3) {
                System.out.println("Please enter a lower bound: ");
                int lowerBound = input.nextInt();
                System.out.println("Please enter an upper bound: ");
                int upperBound = input.nextInt();
                boolean noUpperAndLower = true;
                for (TestResult tr : resultList) {
                    if (tr.getOverallScore() >= lowerBound && tr.getOverallScore() <= upperBound) {
                        System.out.println(tr.toString() + "\nOverall score: " + tr.getOverallScore());
                        System.out.println(line);
                        noUpperAndLower = false;
                    }
                }
                if (noUpperAndLower) {
                    System.out.println("There is no matching result");
                    System.out.println(line);
                }
            }
            else if (option == 4) {
                int highestOverallScore = 0;
                for (TestResult tr : resultList) {
                    if (tr.getOverallScore() > highestOverallScore) {
                        highestOverallScore = tr.getOverallScore();
                    }
                }
                for (TestResult tr : resultList) {
                    if (highestOverallScore == tr.getOverallScore()) {
                        System.out.println(tr.toString());
                        System.out.println(line);
                    }
                }
            }
            else if (option == 5) {
                boolean noPassingTestResult = true;
                for (TestResult tr : resultList) {
                    if (tr.getOverallScore() < 50) {
                        System.out.println(tr.toString());
                        System.out.println(line);
                        noPassingTestResult = false;
                    }
                }
                if (noPassingTestResult) {
                    System.out.println("There is no matching result");
                    System.out.println(line);
                }
            } 
            else if (option == 6) {
                System.out.println("End of program");
            } else {
                System.out.println("Please enter option 1, 2, 3, 4, 5 or 6 only.\n");
            }
        } while (option != 6);
    }
}



class TestResult {
    // private instance variables
    private String id;
    private String name;
    private double score1;
    private double score2;

    // default constructor
    public TestResult() {

    }

    // other constructor
    public TestResult(String id, String name, double score1, double score2) {
        this.id = id;
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore1() {
        return score1;
    }

    public double getScore2() {
        return score2;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSscore1(double score1) {
        this.score1 = score1;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }

    // A method to calculate overall score
    public int getOverallScore() {
        int overallScore = (int) ((score1 * 0.4) + (score2 * 0.6));
        return overallScore;
    }

    // A method to return and grade based on the overall score
    public Grade getGrade() {
        if (getOverallScore() >= 75) {
            return Grade.Good;
        } else if (getOverallScore() >= 50 && getOverallScore() <= 74) {
            return Grade.Pass;
        } else if (getOverallScore() < 50)
            return Grade.Fail;
        else
            return Grade.Fail;
    }

    // Compare instances of TestResult Ids and return true if same Ids
    public boolean compareResult(TestResult tr1) {
        boolean compareResult = false;
        for (TestResult tr : T01F_BenedictOng_A1.resultList) {
            if (tr1.getId().equals(tr.getId())) {
                System.out.println(tr.toString());
                System.out.println(T01F_BenedictOng_A1.line);
                compareResult = true;
            }
        }
        return compareResult;
    }

    // Method to display the corresponding test result
    public String toString() {
        return "Candidate Id: " + getId() + 
                "\nName        : " + getName() + 
                "\nTest 1 Score: " + (int) getScore1() + 
                "\nTest 2 Score: " + (int) getScore2() +
                "\nGrade       : " + getGrade();
    }
}

