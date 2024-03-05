import java.util.Scanner;
public class Main {
    public static String repeatNTimes(String x, int y){
        if (y==1){
            return x;
        }
        else{
            return x+ repeatNTimes(x, y-1);
        }
    }

    public static boolean isReverse(String str1, String str2) {
        if (str1.length() == 0 && str2.length() == 0) {
            return true;
        }
        if (str1.length() != str2.length()) {
            return false;
        }

        if (str1.charAt(0) != str2.charAt(str2.length() - 1)) {
            return false;
        }

        return isReverse(str1.substring(1), str2.substring(0, str2.length() - 1));
    }


    public static void main(String[] args) {
        Scanner sc= new Scanner (System.in);
        System.out.print(repeatNTimes("I must study recursion until it makes sense\n",10));
        System.out.println("Enter the first string: ");
        String input1 = sc.nextLine();
        System.out.println("Enter the second string");
        String input2=sc.nextLine();
        if(isReverse(input1, input2) == true){
            System.out.println(input1 + " is the reverse of " + input2);
        }
        else{
            System.out.println(input1 + " is not the reverse of " + input2);
        }

    }
}