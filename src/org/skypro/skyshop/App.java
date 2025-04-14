package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Яблоко", 50));
        basket.addProduct(new DiscountedProduct("Груша", 100, 10));

        System.out.println("Общая стоимость: " + basket.getTotalPrice());
        basket.printBasket();

        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Апельсин", 200));

        Set<Searchable> results = engine.search("Апе");
        results.forEach(System.out::println);
    }
}