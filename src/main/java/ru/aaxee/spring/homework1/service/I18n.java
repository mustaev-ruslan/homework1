package ru.aaxee.spring.homework1.service;

public interface I18n {

    String translate(String message);

    String translate(String message, Object... args);

    // Short synonym
    default String tr(String message) {
        return translate(message);
    }

    // Short synonym
    default String tr(String message, Object... args) {
        return translate(message, args);
    }

}
