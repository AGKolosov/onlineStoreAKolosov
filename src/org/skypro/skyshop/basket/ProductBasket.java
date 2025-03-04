package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;  // Массив для хранения товаров
    private int count;                 // Количество добавленных товаров

    // Конструктор
    public ProductBasket() {
        this.products = new Product[5];  // Корзина вмещает до 5 товаров
        this.count = 0;
    }

    // Метод добавления продукта в корзину
    public void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт: корзина заполнена.");
        }
    }

    // Метод получения общей стоимости корзины
    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    // Метод печати содержимого корзины
    public void printBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто.");
        } else {
            int specialCount = 0;  // Счетчик специальных товаров
            for (int i = 0; i < count; i++) {
                System.out.println(products[i].toString());
                if (products[i].isSpecial()) {
                    specialCount++;
                }
            }
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    // Метод проверки наличия продукта по имени
    public boolean containsProduct(String name) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // Метод очистки корзины
    public void clearBasket() {
        for (int i = 0; i < count; i++) {
            products[i] = null;
        }
        count = 0;
    }
}