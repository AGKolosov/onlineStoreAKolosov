package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.count = 0;
    }

    public void add(Searchable searchable) {
        if (count < searchables.length) {
            searchables[count] = searchable;
            count++;
        } else {
            System.out.println("Невозможно добавить объект: достигнут лимит.");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int found = 0;

        for (int i = 0; i < count; i++) {
            if (searchables[i].getSearchTerm().contains(query)) {
                results[found] = searchables[i];
                found++;
                if (found == 5) {
                    break;
                }
            }
        }

        return results;
    }
}