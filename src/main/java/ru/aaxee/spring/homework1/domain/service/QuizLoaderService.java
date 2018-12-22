package ru.aaxee.spring.homework1.domain.service;

import ru.aaxee.spring.homework1.domain.entity.QuizQuestion;
import ru.aaxee.spring.homework1.infrastructure.exception.QuizException;

import java.util.List;

public interface QuizLoaderService {

    List<QuizQuestion> getQuizQuestionList(String quizName) throws QuizException;
}
