package ru.aaxee.spring.homework1.domain.service;

import lombok.AllArgsConstructor;
import ru.aaxee.spring.homework1.domain.entity.QuizResult;
import ru.aaxee.spring.homework1.domain.entity.Student;

import java.io.PrintStream;

@AllArgsConstructor
public class ConsoleResultPrintService implements ResultPrintService {

    private String congratulation;
    private PrintStream printStream;

    public void print(Student student, QuizResult quizResult) {

        printStream.println(
                congratulation + " " +
                        student.getLastName() + " " + student.getFirstName() + ", " +
                        "Вы ответили на " + quizResult.getCorrectAnswersCount() +
                        " из " + quizResult.getQuestionsCount() + " вопросов."
        );
    }
}
