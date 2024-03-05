public abstract class Account {
    private static int nextAccountNumber = 10001;
    private int accountNumber;
    private double balance;

    public Account() {
        this(0);
    }

    public Account(double initialBalance) {
        balance = initialBalance;
        accountNumber = nextAccountNumber++;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}