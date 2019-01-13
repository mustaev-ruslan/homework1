package ru.aaxee.spring.homework1.service;

import ru.aaxee.spring.homework1.entity.QuizQuestion;
import ru.aaxee.spring.homework1.entity.QuizResult;

import java.util.List;

public interface QuizService {

    QuizResult run(List<QuizQuestion> quizQuestionList, int maxQuestions);
}
