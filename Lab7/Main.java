//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static int recursive_multiply(int x, int y) {
        int z;
        if (y == 0)
            return 0;
        if (x==0)
            return 0;
        else {
            z = x + recursive_multiply(x, y - 1);
        }
        return z;

    }

    public static int recursive_div(int x, int y){

        if (y==0){
            return -1;}
        if (x<y){
            return 0;
        }
        else{
            return 1 + recursive_div(x - y, y);
        }
    }
    public static int recursive_mod(int x, int y){
        if (y==0){
            return -1;
        }
        if (x<y){
            return x;
        }
        else {
            return (recursive_mod(x-y,y));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice=1;
        do {
            System.out.println("Choose from the following:\n0. Quit\n1. Multiply 2 numbers\n2. Div 2 numbers\n3. Mod 2 numbers ");
            choice = sc.nextInt();
            if (choice ==0){
                break;
            }
            if (choice>3){
                System.out.println("Sorry, that is not an option. Ending program...");
                break;
            }
            System.out.println("Enter first number: ");
            int num1 = sc.nextInt();
            System.out.println("Enter second number: ");
            int num2 = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println(recursive_multiply(num1,num2));
                    break;
                case 2:
                    System.out.println(recursive_div(num1,num2));
                    break;
                case 3:
                    System.out.println(recursive_mod(num1, num2));
                    break;

            }

        }
        while (choice > 0);
    }}
