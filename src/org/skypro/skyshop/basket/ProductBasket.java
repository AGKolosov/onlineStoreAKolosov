package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        }
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name.trim())) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }

    public int getTotalPrice() {
        return products.stream()
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто.");
            return;
        }

        products.forEach(product ->
                System.out.println(product.getName() + ": " + product.getPrice())
        );

        System.out.println("Итого: " + getTotalPrice());
    }
}