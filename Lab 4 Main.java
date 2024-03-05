import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Checking checkingAccount = new Checking();
        Savings savingsAccount = new Savings();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Withdraw from Checking\n2. Withdraw from Savings\n3. Deposit to Checking\n4. Deposit to Savings\n5. Balance of Checking\n6. Balance of Savings\n7. Award Interest to Savings now\n8. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            double amount;

            switch (choice) {
                case 1:
                    System.out.print("How much would you like to withdraw from Checking? ");
                    amount = scanner.nextDouble();
                    checkingAccount.withdraw(amount);
                    break;
                case 2:
                    System.out.print("How much would you like to withdraw from Savings? ");
                    amount = scanner.nextDouble();
                    savingsAccount.withdraw(amount);
                    break;
                case 3:
                    System.out.print("How much would you like to deposit into Checking? ");
                    amount = scanner.nextDouble();
                    checkingAccount.deposit(amount);
                    break;
                case 4:
                    System.out.print("How much would you like to deposit into Savings? ");
                    amount = scanner.nextDouble();
                    savingsAccount.deposit(amount);
                    break;
                case 5:
                    System.out.println("Your balance for checking " + checkingAccount.getAccountNumber() + " is " + checkingAccount.getBalance());
                    break;
                case 6:
                    System.out.println("Your balance for savings " + savingsAccount.getAccountNumber() + " is " + savingsAccount.getBalance());
                    break;
                case 7:
                    savingsAccount.addInterest();
                    break;
                case 8:
                    System.out.println("Quitting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
