package org.skypro.skyshop.product;

public abstract class Product {
    private final String name; // Название продукта

    // Конструктор
    public Product(String name) {
        this.name = name;
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Абстрактный метод для получения цены
    public abstract int getPrice();

    // Метод для проверки, является ли товар специальным
    public abstract boolean isSpecial();
}
