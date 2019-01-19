package ru.aaxee.spring.homework1.service.fake;

import ru.aaxee.spring.homework1.service.I18n;

import java.text.MessageFormat;

public class NoI18n implements I18n {

    @Override
    public String translate(String message, Object... args) {
        return MessageFormat.format(message, args);
    }
}
