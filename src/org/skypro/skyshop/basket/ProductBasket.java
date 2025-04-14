package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new TreeMap<>();

    public void addProduct(Product product) {
        if (product != null) {
            productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>())
                    .add(product);
        }
    }

    public List<Product> removeProductsByName(String name) {
        return Optional.ofNullable(productsMap.remove(name))
                .orElse(Collections.emptyList());
    }

    public int getTotalPrice() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    private long getSpecialCount() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто.");
            return;
        }

        productsMap.forEach((name, products) -> {
            System.out.println("// " + name + " //");
            products.forEach(p ->
                    System.out.println("- " + p.getPrice() + " руб.")
            );
        });

        System.out.println("Итого: " + getTotalPrice() + " руб.");
        System.out.println("Специальных товаров: " + getSpecialCount());
    }
}