import java.util.Scanner;


class BlueRayDisk {
    public String title;
    public String director;
    public int yearOfRelease;
    public double cost;

    public BlueRayDisk(String title, String director, int yearOfRelease, double cost) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("$%.2f %d %s, %s", cost, yearOfRelease, title, director);
    }
}

class Node {
    public BlueRayDisk data;
    public Node next;

    public Node(BlueRayDisk data) {
        this.data = data;
        next = null;
    }
}

class BlueRayCollection {
    private Node head;

    public BlueRayCollection() {
        this.head = null;
    }

    public void add(String title, String director, int yearOfRelease, double cost) {
        BlueRayDisk newDisk = new BlueRayDisk(title, director, yearOfRelease, cost);
        Node newNode = new Node(newDisk);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void showAll() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BlueRayCollection collection = new BlueRayCollection();

        int choice = -1;
        while (choice != 0) {
            System.out.println("0. Quit\n1. Add BlueRay to collection\n2. See collection");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("What is the title?");
                    String title = scanner.nextLine();
                    System.out.println("What is the director?");
                    String director = scanner.nextLine();
                    System.out.println("What is the year of release?");
                    int yearOfRelease = scanner.nextInt();
                    System.out.println("What is the cost?");
                    double cost = scanner.nextDouble();
                    collection.add(title, director, yearOfRelease, cost);
                    break;
                case 2:
                    collection.showAll();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}