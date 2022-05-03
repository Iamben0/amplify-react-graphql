/*
A static method can only access static variable
A static method can only call another static method

An instance method can access instance and static variables
An instance method can call instance and static methods

*/

public class L2SavingAccount {
    private static double INT_RATE = 0.01;  // 1%
    private static double MIN_BAL = 500;
    private static double SVC_FEE = 5;
    private String acctNo;
    private double balance;
    
    public L2SavingAccount(String newAcctNo) {
        acctNo = newAcctNo;
    }

    public L2SavingAccount(String newAcctNo, double initBalance) {
        acctNo = newAcctNo;
        balance = initBalance;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount)
            balance -= amount;
    }

    public void update() {
        double interest = balance * INT_RATE;
        balance += interest;
        if (balance < MIN_BAL)
            balance -= SVC_FEE;
    }

    public static void changeRate(double newRate) {
        if (newRate >= 0)
            INT_RATE = newRate;
    }

    public boolean isSameAccount(L2SavingAccount anotherAcct) {
        if (acctNo.equalsIgnoreCase(anotherAcct.acctNo))   //equalsIsIgnoreCase compares two strings, ignoring lower case and upper case differences. 
            return true;                                   //This method returns true if the strings are equal, and false if not.
        else
            return false;
        }    


    public static void main(String[] args) {
        L2SavingAccount acct1 = new L2SavingAccount("a1");
        L2SavingAccount acct2 = new L2SavingAccount("a2", 100);
        System.out.println(acct1.getBalance());
        System.out.println(acct2.getBalance());
        acct1.update();
        acct2.update();
        System.out.println(acct1.getBalance());
        System.out.println(acct2.getBalance());

        // Static method
        L2SavingAccount.changeRate(0.1);    // static uses class instead of instance
        acct1.update();
        acct2.update();
        System.out.println(acct1.getBalance());
        System.out.println(acct2.getBalance());

        // Comparing instances
        L2SavingAccount acct4 = new L2SavingAccount("a4", 500);
        L2SavingAccount acct5 = new L2SavingAccount("a4", 500);
        System.out.println(acct4 == acct5);             // comparing primitive type when using == as it comparing memory location
        System.out.println(acct4.isSameAccount(acct5));
        System.out.println(acct5.isSameAccount(acct4));
 
    }
}

