package ru.aaxee.spring.homework1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.aaxee.spring.homework1.exception.QuizException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws QuizException {
        ApplicationContext context = SpringApplication.run(Main.class);
        Application application = context.getBean(Application.class);
        application.run();
    }
}
