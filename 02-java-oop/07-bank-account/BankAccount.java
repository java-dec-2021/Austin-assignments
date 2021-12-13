public class BankAccount { 

    private double checkingBalance;
    private double savingsBalance;
    private static double moneyInAccounts;
    private static int numberOfAccounts = 0;

    // constructor
    public BankAccount(){
        numberOfAccounts++;
        moneyInAccounts++;
    }

    // setters
    public void setCheckingBalance(double checkingBalance){
        this.checkingBalance = checkingBalance;
    }

    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }

    public static void setMoneyInAccounts(double moneyInAccounts){
        BankAccount.moneyInAccounts = moneyInAccounts;
    }

    public static void setNumberOfAccounts(int numberOfAccounts){
        BankAccount.numberOfAccounts = numberOfAccounts;
    }

    // getters
    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public static int getNumberOfAccounts(){
        return numberOfAccounts;
    }

    public static double getMoneyInAccounts(){
        return moneyInAccounts;
    }

    // methods
    public void deposit(double amount, String accountType){
        if(accountType.equals("checking")){
            this.setCheckingBalance(this.getCheckingBalance() + amount);
        } else if(accountType.equals("savings")) {
            this.setSavingsBalance(this.getSavingsBalance() + amount);
        } else {
            System.out.println("Account does not exist.");
            return;
        }
        moneyInAccounts += amount;
    }

    public void withdraw(double amount, String accountType){
        if(accountType.equals("checking")){
            if(this.getCheckingBalance()-amount < 0){
                System.out.println("Insufficient funds.");
            } else {
                this.setCheckingBalance(this.getCheckingBalance() - amount);
            }
        } else if(accountType.equals("savings")){
            if(this.getSavingsBalance()-amount < 0){
                System.out.println("Insufficient funds.");
            } else {
                this.setSavingsBalance(this.getSavingsBalance() - amount);
            }
        } else {
            System.out.println("Account does not exist.");
            return;
        }
    }

    public String totalMoney(){
        return "Total amount of money is: Checking: " + this.getCheckingBalance() + " Savings: " + this.getSavingsBalance();
    }
}