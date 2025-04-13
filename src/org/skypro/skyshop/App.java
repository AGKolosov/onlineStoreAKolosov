package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine();

        engine.add(new SimpleProduct("Яблоко", 60));
        engine.add(new Article("Урожай яблок в 2024", "В прошлом году аграриям удалось ..."));
        engine.add(new SimpleProduct("Груша", 80));
        engine.add(new Article("Новости с полей", "Садоводы, по прогнозам ..."));

        System.out.println("Всего уникальных элементов: " + engine.getTotalItems());

        System.out.println("\n=== Результаты поиска ===");
        Set<Searchable> allResults = engine.search("");
        allResults.forEach(item ->
                System.out.println(item.getName() + " (" + item.getSearchTerm().length() + " chars)")
        );

        System.out.println("\n=== Поиск по 'ябл' ===");
        Set<Searchable> searchResults = engine.search("ябл");
        if (searchResults.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            searchResults.forEach(item ->
                    System.out.println(item.getSearchTerm())
            );
        }
    }
}