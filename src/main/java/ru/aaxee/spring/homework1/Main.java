package ru.aaxee.spring.homework1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aaxee.spring.homework1.exception.QuizException;

public class Main {

    public static void main(String[] args) throws QuizException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Application application = context.getBean(Application.class);
        application.run();
    }
}
