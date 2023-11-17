package laboratory.labfive.cash;

public class Cash {
    protected double balance = 800;
    protected double discount;

    public Cash() {
        this.discount = 1;
    }

    @Override
    public String toString() {
        return "\nPlease fall inline to cashier, Cash payment is not yet available this time. Thank you for patience.\n";
    }

    public void calculateBalance(double orderPrice) {
        this.balance -= orderPrice;
    }

    public double calculateDiscount(double orderPrice) {
        balance += orderPrice * discount;
        return orderPrice * discount;
    }

    public double getBalance() {
        return this.balance;
    }
}
