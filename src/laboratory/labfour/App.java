package laboratory.labfour;

import java.util.Arrays;
import java.util.Scanner;
import laboratory.labfour.insured.Insured;

public class App {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        simulator();
        scanner.close();
    }

    static void simulator() {
        while (true) {
            Insured insured = new Insured();

            String id = generateId();
            
            // If the user input wrong customer twice, the system will be terminated
            if (id == null) {
                break;
            }

            insured.setCustomerId(id);

            System.out.print("Please enter your name: ");
            insured.setName(scanner.nextLine());

            System.out.print("Enter model name: ");
            insured.setModelName(scanner.nextLine());

            System.out.print("Enter year purchased: ");
            insured.setYear(scanner.nextInt());
            scanner.nextLine();

            System.out.print("Enter mileage: ");
            insured.setMileage(scanner.nextInt());
            scanner.nextLine();

            displayInfo(insured);
            survey(insured);

            while (true) {
                System.out.print("Do you want to continue? [yes] [no]: ");
                String quit = scanner.nextLine();
                
                if (quit.equalsIgnoreCase("NO")) {
                    return;
                } else if (quit.equalsIgnoreCase("YES")) {
                    break;
                } else {
                    System.out.println("Invalid input.");
                }
            }
        }
    }

    static String generateId() {
        int wrong = 0;
        
        while (wrong < 2) {
            System.out.print("Enter customer's ID: ");
            String id = scanner.nextLine();

            if (id.length() >= 8) {
                return id;
            }
            wrong++;
        }

        System.out.println("System terminated: wrong customer ID, try again!");
        return null;
    }

    static void displayInfo(Insured insured) {
        System.out.println('\n' + insured.getCompanyName());
        System.out.printf("Customer ID: %s%n", insured.getCustomerId());
        System.out.printf("Your car purchased: %s%n", insured.getYear());
        System.out.printf("Model: %s%n", insured.getModelName());
        System.out.printf("Your mileage: %s%n", insured.getMileage());
        System.out.printf(
            "Our system detected that you %s cover for this year. If you want to talk to our sale representative please proceed to customers service desk.%n",
            insured.getMillegeLegend());
    }

    static void survey(Insured insured) {
        System.out.println("\nThis part is for survey only");
        System.out.println("Choose 3 toyota car model that you prefer to buy in the near future");

        String[] surveyStrings = insured.getSurvey();

        String[] num = {"1st", "2nd", "3rd"};
        int surveyQuestion = 3;
        for (int i = 0; i < surveyQuestion; i++) {
            System.out.printf("%s: ", num[i]);
            surveyStrings[i] = scanner.nextLine();
        }

        System.out.println("\nYour participation is well appreciated and your response will be keep in private");
        System.out.println(Arrays.toString(surveyStrings) + '\n');
    }
}
