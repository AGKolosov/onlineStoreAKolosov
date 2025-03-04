package org.skypro.skyshop.product;

public class Product {
    private final String nameProduct;  // Название продукта
    private final int priceProduct;    // Стоимость продукта

    // Конструктор
    public Product(String name, int price) {
        this.nameProduct = name;
        this.priceProduct = price;
    }

    // Геттеры
    public String getName() {
        return nameProduct;
    }

    public int getPrice() {
        return priceProduct;
    }
}