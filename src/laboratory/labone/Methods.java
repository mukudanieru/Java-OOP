package laboratory.labone;

import java.util.Scanner;

class Methods {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        instructions();
        simulation(choose());

        input.close();
    }

    static void instructions() {
        print("This program will calculate the\n");
        print("PERIMETER OF\n");
        print("    * Square\n");
        print("    * Rectangle\n");
        print("AREA OF\n");
        print("    * Rectangle\n");
        print("    * Square\n");
        print("    * Triangle\n");
    }

    static String choose() {
        print("Please choose what to calculate: ");
        return input.nextLine();
    }

    static void simulation(String choosenCal) {
        if (choosenCal.equalsIgnoreCase("perimeter square")) {
            print("Enter side: ");
            print("Perimeter of square: ", perimeterSquare(input.nextInt()));
        } else if (choosenCal.equalsIgnoreCase("perimeter rectangle")) {
            print("Enter length: ");
            int length = input.nextInt();
            input.nextLine();

            print("Enter width: ");
            int width = input.nextInt();
            input.nextLine();

            print("Perimeter of rectangle: ", perimeterRectangle(length, width));
        } else if (choosenCal.equalsIgnoreCase("area square")) {
            print("Enter side: ");
            print("Area of square: ", areaSquare(input.nextInt()));
        } else if (choosenCal.equalsIgnoreCase("area rectangle")) {
            print("Enter length: ");
            int length = input.nextInt();
            input.nextLine();

            print("Enter width: ");
            int width = input.nextInt();
            input.nextLine();

            print("Area of rectangle: ", areaRectangle(length, width));
        } else if (choosenCal.equalsIgnoreCase("area triangle")) {
            print("Enter base: ");
            double base = input.nextDouble();
            input.nextLine();

            print("Enter height: ");
            double height = input.nextDouble();
            input.nextLine();

            print("Area of triangle: ", areaTriangle(base, height));
        } else {
            print("Invalid choice.");
        }
    }

    static void print(String str) {
        System.out.print(str);
    }

    static void print(String str, int integer) {
        System.out.print(str + integer + "\n");
    }

    static void print(String str, double dec) {
        System.out.println(str + dec + "\n");
    }

    static int perimeterSquare(int side) {
        return 4 * side;
    }

    static int perimeterRectangle(int length, int width) {
        return 2 * (length + width);
    }

    static int areaSquare(int side) {
        return side * side;
    }

    static int areaRectangle(int length, int width) {
        return length * width;
    }

    static double areaTriangle(double base, double height) {
        return (base * height) / 2.0;
    }
}