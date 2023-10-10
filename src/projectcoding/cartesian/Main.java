package projectcoding.cartesian;

import java.util.Arrays;
import java.util.Scanner;
import projectcoding.cartesian.point.Point;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Point[] points = new Point[0];
    public static void main(String[] args) {
        simulator();

        scanner.close();
    }

    private static void instructions() {
        System.out.println("- Cartesian Coordinates Simulator -");
        System.out.println("1. Enter a new point");
        System.out.println("2. View the point list");
        System.out.println("3. Check point info");
        System.out.println("4. Get the distance between two points");
        System.out.println("5. Get the slope of a line (two points)");
        System.out.println("6. Exit\n");
    }

    private static void simulator() {
        instructions();


        while (true) {
            System.out.print(" >> ");
            int prompt = scanner.nextInt();

            if (prompt == 1) {
                addPoint();
            } else if (prompt == 2) {
                viewList();
            } else if (prompt == 3) {
                checkPoint();
            } else if (prompt == 4) {
                getDistance();
            } else if (prompt == 5) {
                getSlope();
            } else if (prompt == 6) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }

    private static void addPoint() {
        System.out.println("Adding a new point: ");

        System.out.print("Set: ");
        char p = scanner.next().charAt(0);

        Point point = new Point(p);
        System.out.print("X: ");
        point.setX(scanner.nextDouble());
        scanner.nextLine();

        System.out.print("Y: ");
        point.setY(scanner.nextDouble());
        scanner.nextLine();


        points = Arrays.copyOf(points, points.length+1);
        points[points.length-1] = point;

        System.out.println(point + " has been added.");
    }

    private static void viewList() {
        if (points.length < 1) {
            System.out.println("You haven't add any points in the point list.");
            return;
        }

        for (int i = 0; i < points.length; i++) {
            System.out.println((i+1) + ": " + points[i]);
        } 
    }

    private static int choose() {
        System.out.print("\nChoose: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        return index;
    }

    private static void checkPoint() {
        viewList();

        if (points.length < 1) {
            return;
        }

        Point p = points[choose()-1];
        System.out.println(p);
        System.out.println("Abscissa: " + p.getX());
        System.out.println("Ordinate: " + p.getY());
        System.out.println("Quadrant: Q" + p.getQuadrant());
    }

    private static void getDistance() {
        if (points.length < 2) {
            System.out.println("Your point list need atleast two points.");
            return;
        }

        viewList();

        System.out.println("Getting the distance of two points.");
        System.out.print("\n1st point: ");
        Point p1 = points[choose()-1];

        System.out.print("\n2nd point: ");
        Point p2 = points[choose()-1];

        System.out.println("\nThe distance of " + p1 + " and " + p2 + " is " + p1.distanceTo(p2));
    }

    private static void getSlope() {
        if (points.length < 2) {
            System.out.println("Your point list need atleast two points.");
            return;
        }

        System.out.println("Getting the slope of two points.");
        viewList();

        System.out.print("\n1st point: ");
        Point p1 = points[choose()-1];

        System.out.print("\n2nd point: ");
        Point p2 = points[choose()-1];

        System.out.println("\nThe slope of " + p1 + " and " + p2 + " is " + p1.slope(p2));        
    }
}