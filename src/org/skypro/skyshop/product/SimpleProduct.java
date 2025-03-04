package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;  // Цена товара

    // Конструктор
    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }

    // Переопределение метода getPrice
    @Override
    public int getPrice() {
        return price;
    }

    // Переопределение метода isSpecial
    @Override
    public boolean isSpecial() {
        return false;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }
}
