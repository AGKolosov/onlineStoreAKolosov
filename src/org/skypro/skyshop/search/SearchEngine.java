package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final List<Searchable> searchables = new ArrayList<>();

    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        }
    }

    public Map<String, Searchable> search(String query) {
        if (query == null || query.isBlank()) {
            return Collections.emptyMap();
        }

        String lowerQuery = query.toLowerCase();
        return searchables.stream()
                .filter(item -> item.getSearchTerm().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toMap(
                        Searchable::getName,
                        item -> item,
                        (existing, replacement) -> existing,
                        TreeMap::new
                ));
    }
}