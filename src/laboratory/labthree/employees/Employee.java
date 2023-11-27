package laboratory.labthree.employees;

/**
 *
 * @author mukudanieru
 */
public class Employee {
    protected static int nextEmployeeId = 0; 
    protected int employeeId;
    protected String name;
    protected String jobTitle;
    protected double tax;
        
    public Employee(String name, String jobTitle, double tax) {
        nextEmployeeId++;
        this.employeeId = nextEmployeeId;
        this.name = name;
        this.jobTitle = jobTitle;
        this.tax = tax;
    }
    
    public double grossPay() {
        return 0;
    }
    
    public double taxPay() {
        return this.grossPay() * this.tax;
    }
    
    public double netPay() {
        return this.grossPay() - this.taxPay();
    }
    
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getTax() {
        return tax;
    }
}