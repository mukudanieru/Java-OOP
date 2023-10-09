package projectcoding.inventorymanager.inventory;

import java.util.Arrays;

public class InventoryManager {
    String[] brands = new String[0];
    BoxedProduct[] boxedProducts = new BoxedProduct[0]; 
    SingleProduct[] singleProducts = new SingleProduct[0];

    public void add(SingleProduct p) {
        // Add one individually packed product to the inventory
        String brand = p.getBrand();
        if (!this.contains(brand)) {
            this.brands = Arrays.copyOf(this.brands, this.brands.length+1);
            this.brands[this.brands.length-1] = brand;
        }

        this.singleProducts = Arrays.copyOf(this.singleProducts, this.singleProducts.length+1);
        this.singleProducts[this.singleProducts.length-1] = p;
    }

    public void add(SingleProduct p, int quantity) {
        /* Add the specified number of individually 
        packed product to the inventory */
        for (int i = 0; i < quantity; i++) {
            this.add(p);
        }
    }

    public void add(BoxedProduct p) {
        // Add one box to the inventory
        String brand = p.getBrand();
        if (!this.contains(brand)) {
            this.brands = Arrays.copyOf(this.brands, this.brands.length+1);
            this.brands[this.brands.length-1] = brand;
        }

        this.boxedProducts = Arrays.copyOf(this.boxedProducts, this.boxedProducts.length+1);
        this.boxedProducts[this.boxedProducts.length-1] = p;
    }

    public void add(BoxedProduct p, int quantity) {
        /* Add the specified number of boxes to the 
        inventory */
        for (int i = 0; i < quantity; i++) {
            this.add(p);
        }
    }

    private boolean contains(String brand) {
        return Arrays.binarySearch(this.brands, brand) >= 0;
    }

    public String[] getBrands() {
        return this.brands;
    }

    public SingleProduct[] getSingles(String brand) {
        /* Return the array containing all 
        individually packaged item for the given brand */

        SingleProduct[] products = new SingleProduct[0];

        for (SingleProduct p : this.singleProducts) {
            if (p.getBrand().equals(brand)) {
                products = Arrays.copyOf(products, products.length+1);
                products[products.length-1] = p;
            }
        }

        return products;
    }

    public BoxedProduct[] getBoxes(String brand) {
        // Return the array containing all the boxes for the given brand
        
        BoxedProduct[] products = new BoxedProduct[0];
        
        for (BoxedProduct p : this.boxedProducts) {
            if (p.getBrand().equals(brand)) {
                products = Arrays.copyOf(products, products.length+1);
                products[products.length-1] = p; 
            }
        }

        return products;
    }
}
