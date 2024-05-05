import java.util.Scanner;
public class Main{
    public static void main(String[] args){

        Checking checkingAccount = new Checking(0);
        Savings savingsAccount = new Savings(0);

        int choice = 0;
        do{
            Scanner sc = new Scanner (System.in);

            System.out.println("1. Withdraw from Checking");
            System.out.println("2. Withdraw from Savings");
            System.out.println("3. Deposit to Checking");
            System.out.println("4. Deposit to Savings");
            System.out.println("5. Balance of Checking");
            System.out.println("6. Balance of Savings");
            System.out.println("7. Award Interest to Savings now");
            System.out.println("8. Quit");

            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Your current balance is $" + checkingAccount.getBalance() + ". How much would you like to withdraw from your checking account?");
                    double withdrawChecking = sc.nextDouble();
                    checkingAccount.withdraw(withdrawChecking);
                    System.out.println("You now have " + checkingAccount.getBalance() + " in your " + checkingAccount.getAccountNumber() + " Checking Account");
                    break;
                case 2:
                    System.out.println("Your current balance is $" + savingsAccount.getBalance() + ". How much would you like to withdraw from your savings account?");
                    double withdrawSavings = sc.nextDouble();
                    savingsAccount.withdraw(withdrawSavings);
                    System.out.println("You now have " + savingsAccount.getBalance() + " in your " + savingsAccount.getAccountNumber() + " Savings Account");
                    break;
                case 3:
                    System.out.println("Your current balance is $" + checkingAccount.getBalance() + ". How much would you like to deposit to your checking account?");
                    double depositChecking = sc.nextDouble();
                    checkingAccount.deposit(depositChecking);
                    System.out.println("You now have $"+ checkingAccount.getBalance() + " in your " + checkingAccount.getAccountNumber() + " Checking Account");
                    break;
                case 4:
                    System.out.println("Your current balance is $" + savingsAccount.getBalance() + ". How much would you like to deposit to your savings account?");
                    double depositSavings = sc.nextDouble();
                    savingsAccount.deposit(depositSavings);
                    System.out.println("You now have $"+ savingsAccount.getBalance() + " in your " + savingsAccount.getAccountNumber() + " Savings Account");
                    break;
                case 5:
                    System.out.println("You have $" + checkingAccount.getBalance() + "in your " + checkingAccount.getAccountNumber() + " Checking Account");
                    break;
                case 6:
                    System.out.println("You have $" + savingsAccount.getBalance() + "in your " + savingsAccount.getAccountNumber() + " Savings Account");
                    break;
                case 7:
                    System.out.println("Before interest you have $" + savingsAccount.getBalance());
                    savingsAccount.interest();
                    System.out.println("After interest you have $" + savingsAccount.getBalance());
                    break;
                case 8:
                    System.out.println("Shutting down...");
                    break;
                default:
                    System.out.println("Not a valid choice. Please try again");
                    break;
            }

        } while (choice !=8);

    }
}