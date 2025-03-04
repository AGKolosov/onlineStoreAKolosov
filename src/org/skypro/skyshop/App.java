package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        // Создаем несколько продуктов
        Product product1 = new Product("Яблоко", 50);
        Product product2 = new Product("Банан", 30);
        Product product3 = new Product("Апельсин", 70);

        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // 1. Добавление продукта в корзину
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        // 2. Попытка добавить продукт в заполненную корзину
        basket.addProduct(new Product("Груша", 60));
        basket.addProduct(new Product("Лимон", 40));
        basket.addProduct(new Product("Манго", 100));  // Корзина заполнена

        // 3. Печать содержимого корзины
        System.out.println("\nСодержимое корзины:");
        basket.printBasket();

        // 4. Получение стоимости корзины
        System.out.println("\nОбщая стоимость корзины: " + basket.getTotalPrice());

        // 5. Поиск товара, который есть в корзине
        System.out.println("\nЕсть ли в корзине 'Банан'? " + basket.containsProduct("Банан"));

        // 6. Поиск товара, которого нет в корзине
        System.out.println("Есть ли в корзине 'Манго'? " + basket.containsProduct("Манго"));

        // 7. Очистка корзины
        basket.clearBasket();

        // 8. Печать содержимого пустой корзины
        System.out.println("\nСодержимое корзины после очистки:");
        basket.printBasket();

        // 9. Получение стоимости пустой корзины
        System.out.println("\nОбщая стоимость пустой корзины: " + basket.getTotalPrice());

        // 10. Поиск товара по имени в пустой корзине
        System.out.println("\nЕсть ли в корзине 'Яблоко'? " + basket.containsProduct("Яблоко"));
    }
}