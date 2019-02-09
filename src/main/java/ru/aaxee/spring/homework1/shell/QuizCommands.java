package ru.aaxee.spring.homework1.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.aaxee.spring.homework1.Application;
import ru.aaxee.spring.homework1.exception.QuizException;

@ShellComponent
@RequiredArgsConstructor
public class QuizCommands {

    private final Application application;

    @ShellMethod("Начать тестирование")
    public void start() throws QuizException {
        System.out.println("Старт");
        application.run();
    }

    @ShellMethod("Выйти из тестирвоания")
    public void end() {
        System.out.println("Вы вышли");
        System.exit(0);
    }
}
