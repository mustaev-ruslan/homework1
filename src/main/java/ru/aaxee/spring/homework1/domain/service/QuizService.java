package ru.aaxee.spring.homework1.domain.service;

import ru.aaxee.spring.homework1.domain.entity.QuizQuestion;
import ru.aaxee.spring.homework1.domain.entity.QuizResult;

import java.util.List;

public interface QuizService {

    QuizResult run(List<QuizQuestion> quizQuestionList, int maxQuestions);
}
