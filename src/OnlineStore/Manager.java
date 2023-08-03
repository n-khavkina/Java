package OnlineStore;

import java.util.*;

public class Manager {
    private static int totalPrice = 0;
    static Basket basket = new Basket();

    public static void main(String[] args) {
        addProduct(new Product("Хлеб", 50), 1);
        addProduct(new Product("Молоко", 70), 2);
        addProduct(new Product("Молоко", 80), 1);
        addProduct(new Product("Шоколадка", 100), 3);
        addProduct(new Product("Шоколадка", 100), 3);
        printBasket();
        System.out.println("--------------------------------------------");
        sortBasket(basket.products, "name");
        System.out.println("--------------------------------------------");
        sortBasket(basket.products, "price");
        System.out.println("--------------------------------------------");
        sortBasket(basket.products, "name and price");
    }

    public static void addProduct(Product product, int count) {
        int totalCount = 0;
        if (basket.products.containsKey(product)) {
            totalCount = basket.products.get(product) + count;
        } else {
            totalCount = count;
        }
        basket.products.put(product, totalCount);
        totalPrice += (product.getPrice() * count);
    }

    public static void printBasket() {
        if (basket.products.isEmpty()) {
            System.out.println("Корзина пустая");
        } else {
            System.out.println("Список товаров в корзине:");
            for (Map.Entry<Product, Integer> entry : basket.getProducts().entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " шт.");
            }
            System.out.println("Итоговая стоимость корзины: " + totalPrice + " р.");
        }
    }

    public static void sortBasket(Map<Product, Integer> products, String string) {
        List<Map.Entry<Product, Integer>> list;
        switch (string) {
            case "name":
                list = new ArrayList<>(products.entrySet());
                list.sort(Map.Entry.comparingByKey(new ProductComparatorByName()));
                System.out.println("Сортировка по названию:");
                for (Map.Entry<Product, Integer> entry : list) {
                    System.out.println(entry.getKey() + " - " + entry.getValue() + " шт.");
                }
                break;
            case "price":
                list = new ArrayList<>(products.entrySet());
                list.sort(Map.Entry.comparingByKey(new ProductComparatorByPrice()));
                System.out.println("Сортировка по цене:");
                for (Map.Entry<Product, Integer> entry : list) {
                    System.out.println(entry.getKey() + " - " + entry.getValue() + " шт.");
                }
                break;
            case "name and price":
                list = new ArrayList<>(products.entrySet());
                list.sort(Map.Entry.comparingByKey(new ProductComparatorByName().
                        thenComparing(new ProductComparatorByPrice())));
                System.out.println("Сортировка сначала по названию, затем по цене:");
                for (Map.Entry<Product, Integer> entry : list) {
                    System.out.println(entry.getKey() + " - " + entry.getValue() + " шт.");
                }
                break;
            default:
                System.out.println("Ошибка");
        }
    }
}


