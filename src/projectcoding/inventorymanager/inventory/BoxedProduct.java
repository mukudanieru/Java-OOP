package projectcoding.inventorymanager.inventory;

public class BoxedProduct {
    String brand;
    int quantity;

    public BoxedProduct(String brand, int quantity) {
        this.brand = brand;
        this.quantity = quantity;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
