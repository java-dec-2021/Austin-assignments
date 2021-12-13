public class BankAccountTest {
    public static void main(String[] args){
        // creating both savings and checking
        BankAccount myAccount = new BankAccount();

        // setting initial balances
        myAccount.setCheckingBalance(1500.00);
        myAccount.setSavingsBalance(2000.00);

        // getting balances
        myAccount.getCheckingBalance();
        myAccount.getSavingsBalance();

        // deposits
        myAccount.deposit(200.00, "checking");
        myAccount.deposit(700.00, "savings");

        // withdrawals
        myAccount.withdraw(200, "checking");
        myAccount.withdraw(700, "savings");

        // total money
        System.out.println(myAccount.totalMoney());
    }
}