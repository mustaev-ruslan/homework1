package ru.aaxee.spring.homework1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aaxee.spring.homework1.aspect.Log;
import ru.aaxee.spring.homework1.entity.QuizQuestion;
import ru.aaxee.spring.homework1.entity.QuizResult;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsoleQuizService implements QuizService {

    private final InOutService inOutService;
    private final I18n i18n;

    @Log
    @Override
    public QuizResult run(List<QuizQuestion> quizQuestionList, int maxQuestions) {
        inOutService.write(i18n.tr("Attention!"));
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
