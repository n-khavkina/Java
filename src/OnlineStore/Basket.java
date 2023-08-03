package OnlineStore;

import java.util.HashMap;

public class Basket {
    HashMap <Product, Integer> products;

    public Basket() {
        this.products = new HashMap<>();
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }
}
