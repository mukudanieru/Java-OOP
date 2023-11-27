package laboratory.midterms.atm;

public class Bank implements AutomatedTellerMachine {
    private double balance;

    private final String accountNumber;
    private final String id;

    private String password;
    private final boolean isPasswordChangeable;

    public Bank(String accountNumber, String password, boolean isPasswordChangeable) {
        // a default balance of 5,000 pesos
        this.balance = 5000;

        // personal account details
        this.accountNumber = accountNumber;
        this.id = "SA" + accountNumber;

        // password
        this.password = password;
        this.isPasswordChangeable = isPasswordChangeable;
    }

    public double checkBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }    

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getId() {
        return this.id;
    }

    public void setPassword(String password) {
        if (this.isPasswordChangeable) {
            this.password = password;
        }
        // soon will raise an error
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isPasswordChangeable() {
        return this.isPasswordChangeable;
    }
}
