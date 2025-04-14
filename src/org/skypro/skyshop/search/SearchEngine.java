package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables = new HashSet<>();
    private final SearchableComparator comparator = new SearchableComparator();

    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        }
    }

    public Set<Searchable> search(String query) {
        return searchables.stream()
                .filter(item -> query == null || query.isBlank() ||
                        item.getSearchTerm().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }
}