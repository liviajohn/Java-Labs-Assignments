import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Item[] items = new Item[5];

        int count = 0;

        while (count < 5) {
            System.out.println("Please enter B for Book or P for Periodical");
            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("B")) {
                System.out.println("Please enter the name of the Book");
                String title = scanner.nextLine();
                System.out.println("Please enter the author of the Book");
                String author = scanner.nextLine();
                System.out.println("Please enter the ISBN of the Book");
                String isbn = scanner.nextLine();
                items[count] = new Book(title, isbn, author);
                count++;
            } else if (choice.equals("P")) {
                System.out.println("Please enter the name of the Periodical");
                String title = scanner.nextLine();
                System.out.println("Please enter the issue number");
                int issueNum = Integer.parseInt(scanner.nextLine());
                items[count] = new Periodical(title, issueNum);
                count++;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Your Items:");
        for (Item item : items) {
            System.out.println(item.getListing()+ "\n");
        }
    }
}