package ru.aaxee.spring.homework1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.aaxee.spring.homework1.exception.QuizException;

@Configuration
@ComponentScan
public class Main {

    @Bean
    String congratulation() {
        return "Поздравляем!";
    }

    public static void main(String[] args) throws QuizException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        Application application = context.getBean(Application.class);
        application.run();
    }
}
