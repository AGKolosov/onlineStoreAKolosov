package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        // Создаем несколько продуктов
        SimpleProduct product1 = new SimpleProduct("Яблоко", 50);
        DiscountedProduct product2 = new DiscountedProduct("Банан", 100, 20);  // Скидка 20%
        FixPriceProduct product3 = new FixPriceProduct("Апельсин");

        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Добавляем продукты в корзину
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        // Печать содержимого корзины
        System.out.println("\nСодержимое корзины:");
        basket.printBasket();

        // Получение общей стоимости корзины
        System.out.println("\nОбщая стоимость корзины: " + basket.getTotalPrice());

        // Поиск товара, который есть в корзине
        System.out.println("\nЕсть ли в корзине 'Банан'? " + basket.containsProduct("Банан"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли в корзине 'Манго'? " + basket.containsProduct("Манго"));

        // Очистка корзины
        basket.clearBasket();

        // Печать содержимого пустой корзины
        System.out.println("\nСодержимое корзины после очистки:");
        basket.printBasket();

        // Получение стоимости пустой корзины
        System.out.println("\nОбщая стоимость пустой корзины: " + basket.getTotalPrice());

        // Поиск товара по имени в пустой корзине
        System.out.println("\nЕсть ли в корзине 'Яблоко'? " + basket.containsProduct("Яблоко"));
    }
}