package org.skypro.skyshop.search;

public interface Searchable {
    // Метод получения термина поиска
    String getSearchTerm();

    // Метод получения типа контента
    String getContentType();

    // Метод преобразования объекта в строку (реализация по умолчанию)
    default String getStringRepresentation() {
        return getSearchTerm() + " — " + getContentType();
    }
}