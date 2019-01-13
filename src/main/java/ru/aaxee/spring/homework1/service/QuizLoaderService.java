package ru.aaxee.spring.homework1.service;

import ru.aaxee.spring.homework1.entity.QuizQuestion;
import ru.aaxee.spring.homework1.exception.QuizException;

import java.util.List;

public interface QuizLoaderService {

    List<QuizQuestion> getQuizQuestionList(String quizFilePath) throws QuizException;
}
