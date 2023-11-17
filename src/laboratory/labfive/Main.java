package laboratory.labfive;

import java.util.Scanner;
import laboratory.labfive.cash.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] orders = {"Chicken - 250", "Fries - 100", "Burger - 180"};
    private static double[] prices = {250, 100, 180};

    public static void main(String[] args) {
        simulator();
        scanner.close();
    }

    static void simulator() {
        while (true) {
            System.out.println("[1] Cash [2] Card [3] E-wallet");
            System.out.print("Before ordering, please enter mode of you want: ");

            int prompt = scanner.nextInt();
            scanner.nextLine();

            if (prompt == 1) {
                cashMode();
            } else if (prompt == 2) {
                Card card = new Card();
                cardMode(card);
            } else if (prompt == 3) {
                EWallet eWallet = new EWallet();
                cardMode(eWallet);
            } else {
                System.out.println("Invalid input.");
            }

            System.out.print("Another transaction [1] Yes [2] No: ");
            

            int another = scanner.nextInt();
            scanner.nextLine();

            System.out.println("");

            if (another == 1) {
                continue;
            } else if (another == 2) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    static void menu() {
        System.out.println("\n[250] Chicken [100] Fries [180] Burger");
        System.out.println("Menu: [1] Chicken [2] Fries [3] Burger");
    }

    static void cashMode() {
        Cash paymentMode = new Cash();
        System.out.println(paymentMode);
    }

    static void cardMode(Cash paymentMode) {
        while (true) {
            if ((paymentMode.getBalance() - prices[2]) < 0) {
                System.out.println("\nYou cannot proceed to another order due to low balance, thank you!");
                break;
            }

            menu();

            System.out.print("Please order to menu: ");
            int order = scanner.nextInt();
            scanner.nextLine();

            if ((paymentMode.getBalance() - prices[order  - 1]) < 0) {
                System.out.println("\nYou cannot proceed to another order due to low balance, thank you!");
                break;
            }

            System.out.printf("You ordered: %s%n", orders[order - 1]);
            System.out.printf("Card discount: %.1f%n", paymentMode.calculateDiscount(prices[order - 1]));

            paymentMode.calculateBalance(prices[order - 1]);
            System.out.printf("Current balance: %.1f%n", paymentMode.getBalance());

            System.out.print("\nAnother order? [1] Yes [2] No: ");
            int another = scanner.nextInt();
            scanner.nextLine();

            if (another == 1) {
                continue;
            } else if (another == 2) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
