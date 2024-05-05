public class Savings extends Account{
    private int depositCount = 0;


    public Savings(double balance){
        super(balance);
    }

    @Override
    public void withdraw(double amount){
        super.withdraw(amount);
        if(getBalance()<500){
            System.out.println("Charging a fee of $10 because you are below $500");
            super.withdraw(10);
        }
    }

    @Override
    public void deposit(double amount) {
        depositCount++;
        super.deposit(amount);
        if (depositCount > 5) {
            System.out.println("Charging a fee of $10.");
            super.withdraw(10);
        } else {
            System.out.println("This is deposit number " + depositCount + " to this account.");
        }
    }

    public void interest(){
        double balanceInterest = getBalance()* 0.015;
        System.out.println("Customer earned $" + balanceInterest +" in interest");
        setBalance(getBalance()+balanceInterest);
    }
}
