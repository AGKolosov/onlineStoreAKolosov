package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 100;  // Фиксированная цена

    // Конструктор
    public FixPriceProduct(String name) {
        super(name);
    }

    // Переопределение метода getPrice
    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    // Переопределение метода isSpecial
    @Override
    public boolean isSpecial() {
        return true;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE;
    }
}
