package ru.aaxee.spring.homework1.service;

public interface I18n {

    String translate(String message);

    String translate(String message, Object... args);

}
