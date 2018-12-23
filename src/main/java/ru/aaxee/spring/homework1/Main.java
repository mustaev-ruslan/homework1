package ru.aaxee.spring.homework1;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import ru.aaxee.spring.homework1.exception.QuizException;

import java.util.Locale;

@Configurable
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Main {

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

    public static void main(String[] args) throws QuizException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        Application application = context.getBean(Application.class);
        application.run();
    }
}
