package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new HashMap<>();

    public void addProduct(Product product) {
        if (product != null) {
            productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
        }
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = productsMap.remove(name);
        return removed != null ? removed : Collections.emptyList();
    }

    public int getTotalPrice() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто.");
            return;
        }

        productsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println("// " + entry.getKey() + " //");
                    entry.getValue().forEach(p ->
                            System.out.println("- " + p.getPrice() + " руб.")
                    );
                });

        System.out.println("Итого: " + getTotalPrice() + " руб.");
    }
}