package ru.aaxee.spring.homework1.service;

import java.text.MessageFormat;

public class NoI18n implements I18n {

    @Override
    public String translate(String message) {
        return message;
    }

    @Override
    public String translate(String message, Object... args) {
        return MessageFormat.format(message, args);
    }
}
