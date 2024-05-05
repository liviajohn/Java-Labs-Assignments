import java.io.*;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        try {
            // Prompt user for file names
            System.out.println("Enter the first file name:");
            String fileName1 = scanner.nextLine();
            System.out.println("Enter the second file name:");
            String fileName2 = scanner.nextLine();


            // Open files
            File file1 = new File(fileName1);
            File file2 = new File(fileName2);


            Scanner fileScanner1 = new Scanner(file1);
            Scanner fileScanner2 = new Scanner(file2);


            // Compare files
            int lineNumber = 0;
            boolean different = false;


            while (fileScanner1.hasNextLine() && fileScanner2.hasNextLine()) {
                lineNumber++;


                String line1 = fileScanner1.nextLine();
                String line2 = fileScanner2.nextLine();


                if (!line1.equals(line2)) {
                    different = true;
                    System.out.println("Difference at line " + lineNumber + ":");
                    System.out.println("< " + line1);
                    System.out.println("> " + line2);
                }
            }


            // Check if files have different number of lines
            if (fileScanner1.hasNextLine() || fileScanner2.hasNextLine()) {
                different = true;
                System.out.println("Files have different number of lines.");
            }


            if (!different) {
                System.out.println("Files are identical.");
            }


        } catch (IOException ioe) {
            System.out.println("File not found: " + ioe.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
