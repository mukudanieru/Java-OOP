package laboratory.labthree.employees.hourly;

import laboratory.labthree.employees.Employee;

/**
 * The HourlyEmployee class represents an employee who earns wages based on an hourly rate.
 * 
 * @author mukudanieru
 */
public class HourlyEmployee extends Employee{ 
    private double hourlyRate;
    private int workHours;
    
    public HourlyEmployee(String name, String jobTitle, double tax, double hourlyRate, int workHours) {
        super(name, jobTitle, tax);
        this.hourlyRate = hourlyRate; 
        this.workHours = workHours;
    }
    
    public HourlyEmployee(String name, String jobTitle, double tax, double hourlyRate) {
        this(name, jobTitle, tax, hourlyRate, 0); 
    }

    @Override
    public double grossPay() {
        return this.hourlyRate * this.workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }
}