package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        SimpleProduct product1 = new SimpleProduct("Яблоко", 50);
        DiscountedProduct product2 = new DiscountedProduct("Банан", 100, 20);
        FixPriceProduct product3 = new FixPriceProduct("Апельсин");
        Article article1 = new Article("Как выбрать яблоки", "Советы по выбору свежих яблок.");
        Article article2 = new Article("Польза бананов", "Почему бананы полезны для здоровья.");

        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(article1);
        searchEngine.add(article2);

        try {
            Searchable bestMatch = searchEngine.findBestMatch("ябл");
            System.out.println("Найден наиболее подходящий объект: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("несуществующий запрос");
            System.out.println("Найден наиболее подходящий объект: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}