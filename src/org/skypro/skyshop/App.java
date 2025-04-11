package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Product product1 = new SimpleProduct("Яблоко", 50);
        Product product2 = new SimpleProduct("Банан", 30);
        Product product3 = new SimpleProduct("ЯблокО", 60);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        System.out.println("=== Исходная корзина ===");
        basket.printBasket();

        System.out.println("\nУдаляем 'Яблоко'...");
        List<Product> removed = basket.removeProductsByName(" яБлоко");

        if (!removed.isEmpty()) {
            System.out.println("Удалено товаров: " + removed.size());
            removed.forEach(p -> System.out.println("- " + p.getName() + " (" + p.getPrice() + ")"));
        } else {
            System.out.println("Товары не найдены");
        }

        System.out.println("\n=== Корзина после удаления ===");
        basket.printBasket();

        System.out.println("\nПытаемся удалить 'Апельсин'...");
        removed = basket.removeProductsByName("Апельсин");
        System.out.println(removed.isEmpty() ? "Список пуст" : "Удалено: " + removed.size());

        SearchEngine engine = new SearchEngine();
        engine.add(product1);
        engine.add(product2);
        engine.add(new Article("Фрукты", "Яблоки и бананы полезны для здоровья"));

        System.out.println("\n=== Результаты поиска 'банан' ===");
        List<Searchable> results = engine.search("БанАн");
        results.forEach(r -> System.out.println(r.getSearchTerm()));
    }
}