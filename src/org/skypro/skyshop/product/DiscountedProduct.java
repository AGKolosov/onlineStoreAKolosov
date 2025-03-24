package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;  // Базовая цена
    private final int discount;   // Скидка в процентах

    // Конструктор
    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    // Переопределение метода getPrice
    @Override
    public int getPrice() {
        return basePrice * (100 - discount) / 100;
    }

    // Переопределение метода isSpecial
    @Override
    public boolean isSpecial() {
        return true;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}
