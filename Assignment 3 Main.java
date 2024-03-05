import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Pokemon {
    private int level;
    private double baseCatchRate;

    public Pokemon(int level, double baseCatchRate) {
        this.level = level;
        this.baseCatchRate = baseCatchRate;
    }

    public int getLevel() {
        return level;
    }

    public double getBaseCatchRate() {
        return baseCatchRate;
    }
}

class Bulbasaur extends Pokemon {
    public Bulbasaur(int level) {
        super(level, 0.2);
    }

    @Override
    public String toString() {
        return "A level " + getLevel() + " Bulbasaur";
    }
}

class Caterpie extends Pokemon {
    public Caterpie(int level) {
        super(level, 0.5);
    }

    @Override
    public String toString() {
        return "A level " + getLevel() + " Caterpie";
    }
}

class Charmander extends Pokemon {
    public Charmander(int level) {
        super(level, 0.2);
    }

    @Override
    public String toString() {
        return "A level " + getLevel() + " Charmander";
    }
}

class Pokedex {
    private List<Pokemon> myPokedex;

    public Pokedex() {
        myPokedex = new ArrayList<>();
    }

    public void addToDex(Pokemon pokemon) {
        myPokedex.add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pokemon pokemon : myPokedex) {
            sb.append(pokemon).append("\n");
        }
        return sb.toString();
    }
}

public class Main {
    private static final double CPM = 0.49985844;

    public static void main(String[] args) {
        Pokedex myDex = new Pokedex();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Pokemon encounter = spawn();
            System.out.println("You encounter " + encounter);

            boolean caught = false;
            while (!caught) {
                float multiplier = throwBall(scanner);
                double catchProbability = 1 - Math.pow(1 - encounter.getBaseCatchRate() /( 2 * CPM), multiplier);
                if (Math.random() < catchProbability) {
                    System.out.println("A level " + encounter.getLevel() + " " + encounter.getClass().getSimpleName() + " Caught!");
                    myDex.addToDex(encounter);
                    caught = true;
                } else {
                    System.out.println("Oops, " + encounter + " jumped out, try again!");
                }
            }

            System.out.print("Continue Catching Pokemon? (Y or N): ");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("Y")) {
                break;
            }
        }

        System.out.println("You have the following pokemon:");
        System.out.println(myDex);
    }

    public static Pokemon spawn() {
        Random random = new Random();
        int level = random.nextInt(21);
        int choice = random.nextInt(3);
        switch (choice) {
            case 1:
                return new Bulbasaur(level);
            case 2:
                return new Charmander(level);
            default:
                return new Caterpie(level);
        }
    }

    public static float throwBall(Scanner scanner) {
        System.out.print("What type of ball do you wish to use? (Poke, Great, Ultra): ");
        String ballType = scanner.nextLine();
        float ballMultiplier;
        switch (ballType.toLowerCase()) {
            case "great":
                ballMultiplier = 1.5f;
                break;
            case "ultra":
                ballMultiplier = 2f;
                break;
            default:
                ballMultiplier = 1f;
                break;
        }

        System.out.print("What berry do you wish to use? (None, Razz, SilverPinap, GoldenRazz): ");
        String berryType = scanner.nextLine();
        float berryMultiplier;
        switch (berryType.toLowerCase()) {
            case "razz":
                berryMultiplier = 1.5f;
                break;
            case "silverpinap":
                berryMultiplier = 1.8f;
                break;
            case "goldenrazz":
                berryMultiplier = 2.5f;
                break;
            default:
                berryMultiplier = 1f;
                break;
        }

        System.out.print("Is this a curveball? (Yes or No): ");
        String curveball = scanner.nextLine();
        float curveMultiplier = curveball.equalsIgnoreCase("yes") ? 1.7f : 1f;

        return ballMultiplier * berryMultiplier * curveMultiplier;
    }
}
