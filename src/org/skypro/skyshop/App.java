package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Яблоко", 50));
        basket.addProduct(new SimpleProduct("Банан", 30));
        basket.addProduct(new SimpleProduct("Яблоко", 60));
        basket.addProduct(new DiscountedProduct("Апельсин", 100, 10));

        System.out.println("=== Содержимое корзины ===");
        basket.printBasket();

        System.out.println("\nУдаляем 'Яблоко'...");
        var removed = basket.removeProductsByName("Яблоко");
        System.out.println("Удалено: " + removed.size() + " товаров");

        System.out.println("\n=== Корзина после удаления ===");
        basket.printBasket();

        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Бананы", 60));
        engine.add(new Article("Фрукты", "Яблоки и бананы полезны для здоровья"));
        engine.add(new DiscountedProduct("Груша", 50, 5));

        System.out.println("\n=== Результаты поиска 'банан' ===");
        Map<String, Searchable> results = engine.search("БанАн");
        results.forEach((name, item) ->
                System.out.println(name + ": " + item.getSearchTerm())
        );
    }
}