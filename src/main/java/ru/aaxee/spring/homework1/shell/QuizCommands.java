package ru.aaxee.spring.homework1.shell;

import org.springframework.shell.ExitRequest;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class QuizCommands {

    @ShellMethod("Начать тестирование")
    public void start() {
        System.out.println("Старт");
        throw new ExitRequest();
    }

    @ShellMethod("Выйти из тестирвоания")
    public void end() {
        System.out.println("Вы вышли");
        System.exit(0);
    }
}
