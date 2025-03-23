package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Создаем несколько продуктов
        SimpleProduct product1 = new SimpleProduct("Яблоко", 50);
        DiscountedProduct product2 = new DiscountedProduct("Банан", 100, 20);  // Скидка 20%
        FixPriceProduct product3 = new FixPriceProduct("Апельсин");

        // Создаем несколько статей
        Article article1 = new Article("Как выбрать яблоки", "Советы по выбору свежих яблок.");
        Article article2 = new Article("Польза бананов", "Почему бананы полезны для здоровья.");

        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Добавляем продукты в корзину
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        // Печать содержимого корзины
        System.out.println("\nСодержимое корзины:");
        basket.printBasket();

        // Создаем поисковый движок
        SearchEngine searchEngine = new SearchEngine(10);

        // Добавляем товары и статьи в поисковый движок
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(article1);
        searchEngine.add(article2);

        // Демонстрация поиска
        System.out.println("\nРезультаты поиска по запросу 'яблоко':");
        Searchable[] results = searchEngine.search("яблоко");
        System.out.println(Arrays.toString(results));

        System.out.println("\nРезультаты поиска по запросу 'банан':");
        results = searchEngine.search("банан");
        System.out.println(Arrays.toString(results));

        System.out.println("\nРезультаты поиска по запросу 'польза':");
        results = searchEngine.search("польза");
        System.out.println(Arrays.toString(results));
    }
}