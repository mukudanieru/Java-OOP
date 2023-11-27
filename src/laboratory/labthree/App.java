package laboratory.labthree;

import java.util.Scanner;

import laboratory.labthree.employees.Employee;
import laboratory.labthree.employees.commissioned.CommissionedEmployee;
import laboratory.labthree.employees.hourly.HourlyEmployee;
import laboratory.labthree.employees.salaried.SalariedEmployee;

/**
 * The Main class contains the main program that simulates a simple payroll system.
 * 
 * @author mukudanieru
 */
public class App { 
    private static final Scanner input = new Scanner(System.in); 
    public static void main(String[] args) { 
        instructions(); 
        simulator(); 
        input.close();
    } 
    
    static void instructions() { 
        System.out.println(" -- Simple Payroll Simulator -- "); 
        System.out.println("[1] - Salaried Employee | [2] - Hourly Employee | [3] - Commissioned Employee | [4] - Exit");
    } 
    
    static void simulator() { 
        while (true) { 
            System.out.print("\nChoice: "); 
            int choice = input.nextInt(); 
            input.nextLine(); 
            
            if (choice == 1) {
                output(getSalariedEmployee());
            } else if (choice == 2) {
                output(getHourlyEmployee());
            } else if (choice == 3) {
                output(getCommissionedEmployee());
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }    
    } 

    static String getName() {
        System.out.print("Name: ");
        return input.nextLine();
    }

    static String getJobTitle() {
        System.out.print("Job title: ");
        return input.nextLine();
    }

    static double getTaxRate() {
        System.out.print("Tax percentage: "); 
        return input.nextDouble() / 100.00; 
    }

    static SalariedEmployee getSalariedEmployee() { 
        System.out.println("\n-- Salaried Employee --"); 
        
        String name = getName();
        String job = getJobTitle();
        double tax = getTaxRate();
        input.nextLine(); 
        
        System.out.print("Gross salary: ");
        double salary = input.nextInt(); 
        input.nextLine();
        
        return new SalariedEmployee(name, job, tax, salary);
    }
    
    static HourlyEmployee getHourlyEmployee() {
        System.out.println("\n-- Hourly Employee --");
        
        String name = getName();
        String job = getJobTitle();
        double tax = getTaxRate();
        input.nextLine(); 

        System.out.print("Hourly rate: "); 
        double hourlyRate = input.nextDouble();
        input.nextLine();
        
        int workHours = 0; 
        
        System.out.println("\n-- Your work hours for each weekday --");
        
        String[] weeksday = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (int i = 0, d = weeksday.length; i < d; i++) { 
            System.out.printf("%s: ", weeksday[i]); 
            workHours += input.nextInt();
            input.nextLine();
        } 
        
        System.out.printf("Your total work hours: %d hours%n", workHours);
        return new HourlyEmployee(name, job, tax, hourlyRate, workHours);
    }
    
    static CommissionedEmployee getCommissionedEmployee() {
        System.out.println("\n-- Commissioned Employee --");
        
        String name = getName();
        String job = getJobTitle();
        double tax = getTaxRate();
        input.nextLine(); 

        System.out.print("Commission percent: ");
        double commission = input.nextDouble() / 100.00;
        input.nextLine();
        
        System.out.print("\nNumber of sales: ");
        int numSales = input.nextInt();
        input.nextLine();
        
        CommissionedEmployee em = new CommissionedEmployee(name, job, tax, commission, numSales);
        double[] sales = new double[numSales];
        
        for (int i = 0; i < numSales; i++) { 
            System.out.printf("Sale #%d: ", i+1); 
            
            sales[i] = input.nextDouble();
            input.nextLine();
        }

        em.setSales(sales);
        System.out.printf("Total sales: %,.2f%n", em.totalSales());
        return em;
    }
    
    static void output(Employee employee) {
        System.out.println("\n-- EMPLOYEE OUTPUT --");
        System.out.printf("Employee ID | %-25s | %-20s | %-15s | %-15s | %-15s |%n", 
    "Name", 
            "Job title", 
            "Gross pay", 
            "Tax pay", 
            "Net pay");
        
        System.out.printf("%,-11d | %-25s | %-20s | %,-15.2f | %,-15.2f | %,-15.2f |%n", 
            employee.getEmployeeId(), 
            employee.getName(), 
            employee.getJobTitle(), 
            employee.grossPay(), 
            employee.taxPay(), 
            employee.netPay());
    }
}
