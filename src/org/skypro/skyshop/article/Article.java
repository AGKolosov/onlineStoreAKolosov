package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String title;  // Название статьи
    private final String text;   // Текст статьи

    // Конструктор
    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    // Геттеры
    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    // Реализация метода getSearchTerm
    @Override
    public String getSearchTerm() {
        return toString();  // Используем toString для поиска
    }

    // Реализация метода getContentType
    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return title + "\n" + text;
    }
}