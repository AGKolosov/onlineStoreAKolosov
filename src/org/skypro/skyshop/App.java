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
        SimpleProduct product1 = new SimpleProduct("Яблоко", 50);
        DiscountedProduct product2 = new DiscountedProduct("Банан", 100, 20);
        FixPriceProduct product3 = new FixPriceProduct("Апельсин");

        Article article1 = new Article("Как выбрать яблоки", "Советы по выбору свежих яблок.");
        Article article2 = new Article("Польза бананов", "Почему бананы полезны для здоровья.");

        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        System.out.println("\nСодержимое корзины:");
        basket.printBasket();

        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(article1);
        searchEngine.add(article2);

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