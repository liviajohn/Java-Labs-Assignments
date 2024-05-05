import java.io.*;
import java.util.Scanner;

class ColumnFull extends Exception {
    ColumnFull(String message) {
        super(message);
    }
}

class ConnectFour {
    private char[][] board;
    private String turn;
    private char token;

    ConnectFour() {
        board = new char[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = ' ';
            }
        }
        turn = "Red";
        token = 'R';
    }

    public String getTurn() {
        return turn;
    }

    public char getToken() {
        return token;
    }

    public void nextTurn() {
        if (turn.equals("Red")) {
            turn = "Yellow";
            token = 'Y';
        } else {
            turn = "Red";
            token = 'R';
        }
    }

    public int nextAvailablePosition(int column) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][column] == ' ') {
                return i;
            }
        }
        return -1;
    }

    public void dropPiece(int column, char token) throws ColumnFull {
        int row = nextAvailablePosition(column);
        if (row == -1) {
            throw new ColumnFull("Column is full.");
        }
        board[row][column] = token;
    }

    @Override
    public String toString() {
        String to_return = "  0   1   2   3   4   5   6";
        for (int i = 0; i < 6; i++) {
            to_return+="\n-----------------------------\n";

            to_return+="| ";
            for(int j=0;j<7;j++){
                to_return+=board[i][j]+" | ";
            }
        }
        to_return+="\n-----------------------------\n";
        return to_return;
    }

    public void saveGame() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a filename: ");
            String filename = scanner.nextLine();
            FileWriter writer = new FileWriter(filename);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    writer.write(board[i][j] + ",");
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the game: " + e.getMessage());
        }
    }

    public void loadGame() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a filename: ");
            String filename = scanner.nextLine();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] cells = line.split(",");
                for (int col = 0; col < 7; col++) {
                    board[row][col] = cells[col].charAt(0);
                }
                row++;
            }
            reader.close();
            System.out.println("Game loaded successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while loading the game: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println(game);
            System.out.println("Which column would " + game.getTurn() + " like to go in (7 to save, 8 to load, 9 to quit): ");
            choice = scanner.nextInt();
            if (choice >= 0 && choice <= 6) {
                try {
                    game.dropPiece(choice, game.getToken());
                    game.nextTurn();
                } catch (ColumnFull e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == 7) {
                game.saveGame();
            } else if (choice == 8) {
                game.loadGame();
            }
        } while (choice != 9);
    }
}