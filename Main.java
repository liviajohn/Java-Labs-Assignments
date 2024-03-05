//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;


class Order{
    private int orderID;
    private static int nextorderID =1;
    public boolean ready;
    public String[] items;

    public Order() {
        this.orderID=nextorderID;
        nextorderID ++;
        this.ready=false;
        this.items = new String[3];
        for (int i = 0; i<3; i++) {
            this.items[i] = "";
        }
    }

    public Order(String[] items) {
        this.orderID = nextorderID;
        nextorderID++;
        this.ready=false;
        this.items = items;


    }

    public int getID() {
        return orderID;
        }


public String toString() {
        String result = "Order number: " + orderID + "\n";
        if (ready) {
            result += "Ready\n";
        }
        else {
            result += "Not Ready\n";
        }
        return result.toString();
        }
    }

class OrderList {
    private Order[] orderList;

    public OrderList() {
        orderList = new Order[10]; //helps save space to set it to 10
    }



    public void addOrder(Order order) {
        int index = findEmptySpot();
        if (index != -1) {
            orderList[index] = order;
        } else {
            int newSize = orderList.length * 2;
            Order[] newArray = new Order[newSize];
            for (int i = 0; i < orderList.length; i++) {
                newArray[i] = orderList[i];
            }

            newArray[orderList.length] = order;
            orderList = newArray;

        }

    }

    private int findEmptySpot() {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] == null) {
                return i; // Found an empty spot, return its index
            }
        }
        return -1; // No empty spot found in the existing array
    }


    public void removeOrder(int id) {
        for (int i =0; i < orderList.length; i++) {
            if (orderList[i] != null && orderList[i].getID() ==id) {
                orderList[i] = null;
                return;
            }
        }
    }

    public void readyOrder(int id) {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] != null && orderList[i].getID() == id) {
                orderList[i].ready = true;
                return;
            }
        }

    }

    private void sortOrders() {

            int n = orderList.length;
            boolean swapped;

            do {
                swapped = false;
                for (int i = 1; i <n; i++) {
                    if (orderList [i-1] == null && orderList[i] != null) {
                        Order temp = orderList [i-1];
                        orderList[i-1] =orderList[i];
                        orderList[i] = temp;
                        swapped = true;
                    }
                }
            }
            while (swapped);
        }



    public String printOrder(int id) {
        for (Order order: orderList) {
            if (order != null && order.getID() == id) {
                return order.toString();
            }
        }
        return "";
    }

    public String printOrders() {
        sortOrders();
        StringBuilder result = new StringBuilder ();
        result.append("READY\n");
        for (Order order : orderList) {
            if (order != null && order.ready) {
                result.append(order.getID()).append("\n");
            }
        }
        result.append("PENDING\n");

        for (Order order : orderList) {
            if (order != null && !order.ready) {
                result.append(order.getID()).append("\n");
            }
        }
        return result.toString();
    }

}



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderList restaurantOrders = new OrderList();
        while (true) {
            System.out.println("Please select a menu option: \n1. Create order\n2. Delete order\n3. Ready order\n4. Print order\n5. Print all orders\n6. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create order
                    String[] items = new String[3];
                    for (int i = 0; i < items.length; i++) {
                        System.out.print("Enter item " + (i + 1) + ": ");
                        scanner.nextLine(); // Consume newline
                        items[i] = scanner.nextLine();
                    }
                    Order newOrder = new Order(items);
                    restaurantOrders.addOrder(newOrder);
                    System.out.println("Order has been added");
                    break;
                case 2:
                    // Delete order
                    System.out.print("Please enter order id");
                    int deleteId = scanner.nextInt();
                    restaurantOrders.removeOrder(deleteId);
                    System.out.println("Order has been removed");
                    break;
                case 3:
                    // Ready order
                    System.out.print("Enter order ID to mark as ready: ");
                    int readyId = scanner.nextInt();
                    restaurantOrders.readyOrder(readyId);
                    System.out.println("Order has been set to 'Ready'");
                    break;
                case 4:
                    // Print order
                    System.out.print("Please enter order id:");
                    int printId = scanner.nextInt();
                    String orderDetails = restaurantOrders.printOrder(printId);
                    if (orderDetails.isEmpty()) {
                        System.out.println("No such order found");
                    } else {
                        System.out.println(orderDetails);
                    }
                    break;
                case 5:
                    // Print all orders
                    String allOrders = restaurantOrders.printOrders();
                    System.out.println(allOrders);
                    break;
                case 6:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }
}