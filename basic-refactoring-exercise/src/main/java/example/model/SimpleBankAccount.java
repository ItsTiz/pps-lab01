package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {

    private double balance;
    private final AccountHolder holder;
    private static final double WITHDRAWAL_FEE = 1;

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount + WITHDRAWAL_FEE;
        }
    }

    private boolean isWithdrawAllowed(final double amount) throws IllegalArgumentException{
        if(amount == 0) throw new IllegalArgumentException();
        return this.balance >= amount + WITHDRAWAL_FEE;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
