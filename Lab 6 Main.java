import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number you want to find the Fibonacci Series for:");
        int n = scanner.nextInt();

        FindFib fibIteration = new FibIteration();
        FindFib fibFormula = new FibFormula();

        int fibIter = fibIteration.calculate_fib(n);
        int fibForm = fibFormula.calculate_fib(n);

        System.out.println("Fib of " + n + " by iteration is: " + fibIter);
        System.out.println("Fib of " + n + " by formula is: " + fibForm);
    }
}
