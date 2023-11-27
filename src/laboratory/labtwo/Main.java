package laboratory.labtwo;

import java.util.Scanner;

import laboratory.labtwo.person.Person;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Person person = registerPerson();
        System.out.printf("Hi! %s welcome to our program%n", person.getName());

        simulator();
        credentials(person);

        input.close();
    }

    static void simulator() {
        System.out.print("Please choose process [[1] Calculate base of a triangle [2] Calculate the sum of all input numbers]: ");

        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1 : baseTriangle(); break;
            case 2 : sumNum(); break;
            default: System.out.println("Invalid choice."); break;
        }

    }

    static void sumNum() {
        System.out.print("Enter how many times to input numbers: ");
        int times = input.nextInt();
        input.nextLine();

        int sum = 0;
        for (int i = 0; i < times; i++) {
            System.out.print("Enter number: ");
            sum += input.nextInt();
            input.nextLine();
        }

        System.out.printf("Answer is %d%n", sum);
    }

    static void baseTriangle() {
        System.out.print("Enter height: ");
        double h = input.nextDouble();
        input.nextLine();

        System.out.print("Enter area: ");
        double a = input.nextDouble();
        input.nextLine();

        System.out.printf("The base of triangle is: %f%n", (2 * a) / h);
    }

    static void credentials(Person person) {
        System.out.printf("Thank you! %s for using this program%n", person.getName());
        System.out.println("This is your credentials entered in the system");
        System.out.printf("Name: %s%n", person.getName());
        System.out.printf("Email: %s%n", person.getEmail());
        System.out.printf("Address: %s%n", person.getAddress());
        System.out.printf("Age: %d%n", person.getAge());
        System.out.printf("Sex: %c%n", person.getSex());
    }

    static Person registerPerson() {
        Person currentPerson = new Person();

        System.out.print("Enter your name: ");
        currentPerson.setName(input.nextLine());

        System.out.print("Enter your email: ");
        currentPerson.setEmail(input.nextLine());

        System.out.print("Enter your address: ");
        currentPerson.setAddress(input.nextLine());

        System.out.print("Enter sex: ");
        currentPerson.setSex(input.nextLine().charAt(0));

        System.out.print("Enter age: ");
        currentPerson.setAge(input.nextInt());
        input.nextLine();

        return currentPerson;
    }
}
