package ru.aaxee.spring.homework1.domain.service;

import ru.aaxee.spring.homework1.domain.entity.QuizResult;
import ru.aaxee.spring.homework1.domain.entity.Student;

public interface ResultPrintService {
    void print(Student student, QuizResult quizResult);
}
