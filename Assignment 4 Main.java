import java.util.Random;
import java.util.Scanner;

abstract class Language {
    abstract String make_guess();
    abstract String too_low();
    abstract String too_high();
    abstract String correct();
}

class English extends Language {
    @Override
    String make_guess() {
        return "Guess a number";
    }

    @Override
    String too_low() {
        return "Too Low";
    }

    @Override
    String too_high() {
        return "Too High";
    }

    @Override
    String correct() {
        return "Correct";
    }
}

class Spanish extends Language {
    @Override
    String make_guess() {
        return "Adivina un numero";
    }

    @Override
    String too_low() {
        return "Demasiado bajo";
    }

    @Override
    String too_high() {
        return "Demasiado alto";
    }

    @Override
    String correct() {
        return "Correcto";
    }
}

class French extends Language {
    @Override
    String make_guess() {
        return "Devinez un nombre";
    }

    @Override
    String too_low() {
        return "Trop bas";
    }

    @Override
    String too_high() {
        return "Trop haut";
    }

    @Override
    String correct() {
        return "Correct";
    }
}

class SimplifiedChinese extends Language {
    @Override
    String make_guess() {
        return "猜一个数字";
    }

    @Override
    String too_low() {
        return "太低";
    }

    @Override
    String too_high() {
        return "太高";
    }

    @Override
    String correct() {
        return "正确";
    }
}

class GuessNumber {
    private Random myRand;

    public GuessNumber() {
        myRand = new Random();
    }

    public void play_game() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your language");
        System.out.println("1. English");
        System.out.println("2. Español");
        System.out.println("3. Français");
        System.out.println("4. 简体中文");

        int choice = scanner.nextInt();
        Language myLang = null;

        switch (choice) {
            case 1:
                myLang = new English();
                break;
            case 2:
                myLang = new Spanish();
                break;
            case 3:
                myLang = new French();
                break;
            case 4:
                myLang = new SimplifiedChinese();
                break;
            default:
                System.out.println("Invalid choice. Defaulting to English.");
                myLang = new English();
        }

        int randomNumber = myRand.nextInt(100);
        int guess = -1;

        while (guess != randomNumber) {
            System.out.println(myLang.make_guess());
            guess = scanner.nextInt();
            if (guess < randomNumber)
                System.out.println(myLang.too_low());
            else if (guess > randomNumber)
                System.out.println(myLang.too_high());
            else
                System.out.println(myLang.correct());
        }

        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        GuessNumber game = new GuessNumber();
        game.play_game();
    }
}
