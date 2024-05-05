public class Account {
    private int accountNumber;
    private double balance =0;
    private static int nextAccountNumber = 1001;


    public Account(double balance){
        this.balance = balance;
        accountNumber = nextAccountNumber++;

    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double amount){
        balance = amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public void deposit(double amount){
        balance += amount;
    }

}