package ru.aaxee.spring.homework1.domain.service;

import lombok.AllArgsConstructor;
import ru.aaxee.spring.homework1.domain.entity.QuizQuestion;
import ru.aaxee.spring.homework1.domain.entity.QuizResult;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class ConsoleQuizService implements QuizService {

    private InputStream inputStream;
    private PrintStream printStream;

    public QuizResult run(List<QuizQuestion> quizQuestionList, int maxQuestions) {
        Scanner scanner = new Scanner(inputStream);
        printStream.println("Внимание!");
        int correctAnswersCount = 0;
        int to = Math.min(maxQuestions, quizQuestionList.size()) - 1;
        for (QuizQuestion quizQuestion : quizQuestionList.subList(0, to)) {
            printStream.println(quizQuestion.getQuestion());
            String userAnswer = scanner.nextLine();
            if (userAnswer.equals(quizQuestion.getAnswer())) {
                correctAnswersCount++;
            }
        }
        return new QuizResult(quizQuestionList.size(), correctAnswersCount);
    }
}
