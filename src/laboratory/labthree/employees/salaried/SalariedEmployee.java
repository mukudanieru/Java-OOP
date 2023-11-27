package laboratory.labthree.employees.salaried;

import laboratory.labthree.employees.Employee;

/**
 * The SalariedEmployee class represents an employee who earns a fixed salary.
 * 
 * @author mukudanieru
 */
public class SalariedEmployee extends Employee { 
    private double salary;
    
    public SalariedEmployee(String name, String jobTitle, double tax, double salary) {
        super(name, jobTitle, tax);
        this.salary = salary;
    }
    
    @Override
    public double grossPay() {
        return this.salary;
    }
}
