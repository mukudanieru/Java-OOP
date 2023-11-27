package laboratory.labthree.employees.commissioned;

import laboratory.labthree.employees.Employee;

/**
 * The CommissionedEmployee class represents an employee who earns commissions based on sales.
 * 
 * @author mukudanieru
 */
public class CommissionedEmployee extends Employee {
    private double commissionPercent;
    private int numberOfSales;
    private double[] sales;
    
    public CommissionedEmployee(String name, String jobTitle, double tax, double commissionPercent, int numberOfSales) {
        super(name, jobTitle, tax);
        this.commissionPercent = commissionPercent; 
        this.numberOfSales = numberOfSales;
        this.sales = new double[numberOfSales];
    }
    
    public double totalSales() {
        double sum = 0;
        
        for (int i = 0; i < this.numberOfSales; i++) {
            sum += this.sales[i];
        }
        
        return sum;
    }
    
    @Override
    public double grossPay() {
        return this.commissionPercent * this.totalSales(); 
    }

    public void setSales(double[] sales) {
        this.sales = sales;
    }
}