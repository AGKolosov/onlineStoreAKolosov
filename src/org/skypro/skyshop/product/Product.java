package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name;  // Название продукта

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

    // Реализация метода getSearchTerm
    @Override
    public String getSearchTerm() {
        return getName();  // Используем имя товара для поиска
    }

    // Реализация метода getContentType
    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}