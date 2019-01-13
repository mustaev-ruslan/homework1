package ru.aaxee.spring.homework1.service;

import lombok.AllArgsConstructor;
import ru.aaxee.spring.homework1.entity.QuizQuestion;
import ru.aaxee.spring.homework1.entity.QuizResult;

import java.util.List;

@AllArgsConstructor
public class ConsoleQuizService implements QuizService {

    private InOutService inOutService;

    @Override
    public QuizResult run(List<QuizQuestion> quizQuestionList, int maxQuestions) {
        inOutService.write("Внимание!");
        int correctAnswersCount = 0;
        int to = Math.min(maxQuestions, quizQuestionList.size());
        for (QuizQuestion quizQuestion : quizQuestionList.subList(0, to)) {
            inOutService.write(quizQuestion.getQuestion());
            String userAnswer = inOutService.read();
            if (userAnswer.equals(quizQuestion.getAnswer())) {
                correctAnswersCount++;
            }
        }
        return new QuizResult(quizQuestionList.size(), correctAnswersCount);
    }
}
