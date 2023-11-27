package laboratory.midterms.atm;

public interface AutomatedTellerMachine {
    double checkBalance();
    void deposit(double amount);
    void withdraw(double amount);
}
