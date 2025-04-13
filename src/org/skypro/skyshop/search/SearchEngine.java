package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables = new HashSet<>();
    private final SearchableComparator comparator = new SearchableComparator();

    public void add(Searchable searchable) {
        if (searchable != null) {
            boolean added = searchables.add(searchable);
            if (!added) {
                System.out.println("Элемент '" + searchable.getName() + "' уже существует и не был добавлен");
            }
        }
    }

    public Set<Searchable> search(String query) {
        if (query == null || query.isBlank()) {
            return new TreeSet<>(comparator) {{
                addAll(searchables);
            }};
        }

        String lowerQuery = query.toLowerCase();
        return searchables.stream()
                .filter(item -> item.getSearchTerm().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }

    public int getTotalItems() {
        return searchables.size();
    }
}