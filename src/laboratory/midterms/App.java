package laboratory.midterms;

import java.util.Scanner;

import laboratory.midterms.atm.Bank;


public class App {
    private static final int NUM_ACCOUNTS = 5;
    private static final Bank[] accounts = new Bank[NUM_ACCOUNTS];

    private static final double DEFAULT_BALANCE = 20000.36;
    private static final String PROCESS_MESSAGE = "P R O C E S S I N G . . . . .";
    private static Bank currentAccount;

    private static final Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        createAccounts();

        while (true) {
            System.out.println("AUTOMATED TELLER MACHINE");
            System.out.print("Input PIN: ");
            String pin = input.nextLine();

            currentAccount = searchAccount(pin);
            if (currentAccount == null) {
                System.out.println("Wrong pin!");
                return;
            }
            currentAccount.setBalance(DEFAULT_BALANCE);

            simulator(pin);

            while (true) {
                int remove = getInt("\nDo you want to remove this card? [1] Y [2] N: ");

                if (remove == 1) {
                    System.out.println("Get your card.");
                    input.close();
                    return;
                } else if (remove == 2) {
                    System.out.println();
                    break;
                } else {
                    System.out.println("INVALID INPUT!");
                }
            }
        }
    }

    private static void simulator(String pin) {
        while (true) {
            menu();

            int prompt = getInt("Enter here: ");

            if (prompt == 1) {
                checkBalance();
            } else if (prompt == 2) {
                withdrawal();
            } else if (prompt == 3) {
                deposit();
            } else if (prompt == 4) {
                displayAccount();
            } else if (prompt == 5) {
                changePin(pin);
            } else {
                System.out.println("Sorry, other bank transaction is undermaintenance.");
            }


            while (true) {
                int remove = getInt("\nDo you want another transaction? [1] Y [2] N: ");

                if (remove == 1) {
                    break;
                } else if (remove == 2) {
                    return;
                } else {
                    System.out.println("INVALID INPUT!");
                }
            }
        }
    }

    private static void changePin(String pin) {
        if (!currentAccount.isPasswordChangeable()) {
            System.out.println("This pin cannot be changed.");
            return;
        }

        System.out.print("Input OLD pin: ");
        String oldPin = input.nextLine();

        if (!oldPin.equals(pin)) {
            System.out.println("Pin did not match. Try again later!");
            return;
        }

        System.out.print("Input NEW pin: ");
        currentAccount.setPassword(input.nextLine());

        System.out.println("Successful");
    }

    private static void displayAccount() {
        System.out.printf("Your account number: %s%n", currentAccount.getAccountNumber());
        System.out.printf("Your ID number: %s%n", currentAccount.getId());
    }

    private static void deposit() {
        System.out.println("D E P O S I T");

        System.out.print("Enter amount");        

        currentAccount.deposit(input.nextDouble());
        input.nextLine();

        System.out.println(PROCESS_MESSAGE);
        System.out.println(currentBalance());
    }

    private static void withdrawal() {
        System.out.println("W I T H D R A W");
        
        System.out.print("Enter amount: ");
        double amount = input.nextDouble();
        input.nextLine();

        if ((currentAccount.checkBalance() - amount) < 0) {
            System.out.println("You have insufficient funds to complete this withdrawal. Please check your account balance and try again.");
            return;
        }

        currentAccount.withdraw(amount);

        System.out.println(PROCESS_MESSAGE);
        System.out.println(currentBalance());
    }

    private static void checkBalance() {
        System.out.println("B A L A N C E");
        System.out.println(PROCESS_MESSAGE);
        System.out.println(currentBalance());
    }

    private static String currentBalance() {
        return String.format("Current balance: %,.2f", currentAccount.checkBalance());
    }

    private static void menu() {
        System.out.println("\n[1] BALANCE [2] WITHDRAW [3] DEPOSIT [4] GET ACCOUNT NUMBER [5] CHANGE PIN [6] SOON\n");
    }

    private static Bank searchAccount(String pin) {
        for (int i = 0; i < NUM_ACCOUNTS; i++) {
            if (pin.equals(accounts[i].getPassword())) {
                return accounts[i];
            }
        }
        return null;
    }

    private static int getInt(String message) {
        System.out.print(message);
        int getInt = input.nextInt();
        input.nextLine();
        return getInt;
    }

    private static void createAccounts() {
        accounts[0] = new Bank("125870", "1234", true);
        accounts[1] = new Bank("789456", "5678", true);
        accounts[2] = new Bank("996687", "4321", true);
        accounts[3] = new Bank("225588", "8765", false);
        accounts[4] = new Bank("335574", "1111", false);
    }
}
