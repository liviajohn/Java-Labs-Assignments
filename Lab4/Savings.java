public class Savings extends Account {
    private int depositCount = 0;

    public Savings() {
        super();
    }

    public Savings(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        depositCount++;
        super.deposit(amount);
        if (depositCount > 5) {
            System.out.println("Charging a fee of $10.");
            super.withdraw(10); // Deduct the deposit fee
        } else {
            System.out.println("This is deposit number " + depositCount + " to this account.");
        }
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        if (getBalance() < 500) {
            System.out.println("Charging a fee of $10 because you are below $500.");
            super.withdraw(10); // Deduct the below minimum balance fee
        }
    }

    public void addInterest() {
        double interest = getBalance() * 0.015; // 1.5% interest
        super.deposit(interest);
        System.out.println("Customer earned " + interest + " in interest.");
    }
}