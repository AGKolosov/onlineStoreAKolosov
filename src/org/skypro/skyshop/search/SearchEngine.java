package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {
    private final Searchable[] searchables;  // Массив для хранения объектов
    private int count;                      // Количество добавленных объектов

    // Конструктор
    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.count = 0;
    }

    // Метод добавления объекта
    public void add(Searchable searchable) {
        if (count < searchables.length) {
            searchables[count] = searchable;
            count++;
        } else {
            System.out.println("Невозможно добавить объект: достигнут лимит.");
        }
    }

    // Метод поиска
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];  // Массив для результатов
        int found = 0;  // Количество найденных объектов

        for (int i = 0; i < count; i++) {
            if (searchables[i].getSearchTerm().contains(query)) {
                results[found] = searchables[i];
                found++;
                if (found == 5) {
                    break;  // Прерываем поиск, если найдено 5 объектов
                }
            }
        }

        return results;
    }
}