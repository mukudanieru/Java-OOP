package projectcoding.inventorymanager;

import java.util.Scanner;

import projectcoding.inventorymanager.inventory.BoxedProduct;
import projectcoding.inventorymanager.inventory.InventoryManager;
import projectcoding.inventorymanager.inventory.SingleProduct;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final InventoryManager i = new InventoryManager();
    public static void main(String[] args) {
        simulator();

        scanner.close();
    }

    private static void instructons() {
        System.out.println("Options: ");
        System.out.printf(
        "%26s%n%23s%n%12s%n",
        "[1] Add Single Product",
        "[2] Add Box Product",
        "[3] Exit"
        );
    }

    private static void simulator() {
        while (true) {
            instructons();

            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Brand: ");
                String brand = scanner.nextLine();

                System.out.print("Quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                i.add(new SingleProduct(brand), quantity);
            } else if (choice == 2) {
                System.out.print("Brand: ");
                String brand = scanner.nextLine();

                System.out.print("Items in box: ");
                int items = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                i.add(new BoxedProduct(brand, items), quantity);
            } else if (choice == 3) {
                simulatorOutput();
                break;
            } else {
                System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }

    private static void simulatorOutput() {
        System.out.println("\n- Inventory Report -");

        String[] brands = i.getBrands();

        for (String brand : brands) {
            System.out.println("\n" + brand);

            int singles = i.getSingles(brand).length;

            System.out.printf("%13s: %d%n", "Singles: ", singles);

            BoxedProduct[] boxedProducts = i.getBoxes(brand);

            System.out.printf("%11s: %d%n", "Boxes: ", boxedProducts.length);
            
            System.out.printf("%18s: %d%n", "Total pieces: ", (singles + piecesBox(boxedProducts)));
        }

    }

    private static int piecesBox(BoxedProduct[] bp) {
        int pieces = 0;

        for (BoxedProduct p : bp) {
            pieces += p.getQuantity();
        }
        return pieces;
    }
}
