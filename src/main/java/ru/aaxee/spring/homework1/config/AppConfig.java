package ru.aaxee.spring.homework1.config;

import org.jline.utils.AttributedString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.shell.jline.PromptProvider;

import java.util.Locale;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan
public class AppConfig {

    @Value("${locale}")
    private String languageTag;

    @Bean
    Locale locale() {
        return Locale.forLanguageTag(languageTag);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

    @Bean
    public PromptProvider promptProvider() {
        return () -> new AttributedString("Квиз(start/end):>");
    }
}
