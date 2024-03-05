
import java.util.Scanner;

class StockItem {
    static int lastID = 0;
    String description = "";
    private float price = 0.00f;
    int quantity = 0;
    int id = lastID;



    StockItem(String description, float price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        lastID++;

    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    void newPrice(float newPrice) {
        if (newPrice < 0)
            System.out.println("Error: Sorry, new price cannot be less than $0.00.");
        else
            price = newPrice;
    }

    void lowerQuantity(int lowerQuantity) {
        if ((quantity - lowerQuantity) < 0)
            System.out.println("Sorry, we have " + quantity + "in stock at the moment");
        else
            quantity = quantity - lowerQuantity;
    }

    void raiseQuantity(int raiseQuantity) {
        quantity = quantity + raiseQuantity;
    }
}

public class Main {
    public static void main(String[] args) {

        StockItem milk = new StockItem("1 Gallon of Milk", 3.60f, 15);
        milk.lastID++;
        StockItem bread = new StockItem ("1 Loaf of Bread", 1.98f, 30);
        milk.lastID++;

        bread.setPrice(5f);



        Scanner op = new Scanner (System.in);
        int option = 0;
        do {
            System.out.println("Menu:\n1. Sold One Milk\n2. Sold One Bread\n3. Change price of Milk\n4. Change price of Bread\n5. Add Milk to Inventory\n6. Add Bread to Inventory\n7. See Inventory\n8. Quit");
            System.out.println("Please enter an option: ");
            option = op.nextInt();
            switch (option) {
                case 1:
                    milk.lowerQuantity(1);
                    break;
                case 2:
                    bread.lowerQuantity(1);
                    break;
                case 3:
                    System.out.println("What is the new price for Milk?");
                    Scanner mp = new Scanner(System.in);
                    float milkPrice = mp.nextFloat();
                    milk.newPrice(milkPrice);
                    break;
                case 4:
                    System.out.println("What is the new price for Bread?");
                    Scanner bp = new Scanner(System.in);
                    float breadPrice = bp.nextFloat();
                    bread.newPrice(breadPrice);
                    break;
                case 5:
                    System.out.println("How many cartons of milk did we get?");
                    Scanner mq = new Scanner(System.in);
                    int milkQuantity = mq.nextInt();
                    milk.raiseQuantity(milkQuantity);
                    break;
                case 6:
                    System.out.println("How many loaves of bread did we get?");
                    Scanner bq = new Scanner(System.in);
                    int breadQuantity = bq.nextInt();
                    bread.raiseQuantity(breadQuantity);
                    break;
                case 7:
                    System.out.println("Milk: Item number: " + milk.id + " is " + milk.description + " has price " + milk.getPrice() + " we currently have " + milk.quantity + " in stock\n" + "Bread: Item number: " + bread.id + " is " + bread.description + " has price " + bread.getPrice() + " we currently have " + bread.quantity + " in stock");
                    break;
            }

        }
        while(option<8);
    }
}
