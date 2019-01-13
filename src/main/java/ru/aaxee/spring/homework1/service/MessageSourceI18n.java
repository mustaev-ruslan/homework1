package ru.aaxee.spring.homework1.service;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@AllArgsConstructor
public class MessageSourceI18n implements I18n {

    private final MessageSource messageSource;
    private final Locale locale;

    @Override
    public String translate(String message) {
        return messageSource.getMessage(message, null, locale);
    }

    @Override
    public String translate(String message, Object... args) {
        return messageSource.getMessage(message, args, locale);
    }
}
