package org.skypro.skyshop.search;

import java.util.Objects;

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

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (int i = 0; i < count; i++) {
            String searchTerm = searchables[i].getSearchTerm();
            int count = countOccurrences(searchTerm, search);

            if (count > maxCount) {
                maxCount = count;
                bestMatch = searchables[i];
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящего объекта для поискового запроса: " + search);
        }

        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }
}