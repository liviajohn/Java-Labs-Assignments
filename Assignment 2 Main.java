import java.util.Scanner;
class WordGuessHelper {

    // Method to check if a word contains a specific letter
    public static boolean wordContainsLetter(String word, char letter) {
        for (char c : word.toCharArray()) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }



    // Method to guess words based on letters
    public static void guessWordWithLetters(English english, int length, String letters) {
        System.out.println("It might be any of these...");
        for (String word : english.words) {
            if (word.length() == length) {
                boolean allLettersPresent = true;
                for (char letter : letters.toCharArray()) {
                    if (!wordContainsLetter(word, letter)) {
                        allLettersPresent = false;
                        break;
                    }
                }
                if (allLettersPresent) {
                    System.out.println(word);
                }
            }
        }
    }
    // Method to check if a word contains a specific string
    public static boolean wordContainsString(String word, String str) {
        return word.contains(str);
    }
    // Method to guess words based on a pattern
    public static void guessWordWithPattern(English english, int length, String pattern) {
        System.out.println("It might be any of these...");
        for (String word : english.words) {
            if (word.length() == length && wordContainsString(word, pattern)) {
                System.out.println(word);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        English english = new English();

        System.out.println("How many letters are in the word?");
        int length = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Do you want me to look for letters or a pattern?\n1. Letters\n2. Pattern");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("What letters are in the word?");
                String letters = scanner.nextLine();
                guessWordWithLetters(english, length, letters);
                break;
            case 2:
                System.out.println("What pattern is in the word?");
                String pattern = scanner.nextLine();
                guessWordWithPattern(english, length, pattern);
                break;
            default:
                System.out.println("Invalid choice.");
        }

    }

    }
