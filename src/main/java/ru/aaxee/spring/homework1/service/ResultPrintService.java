package ru.aaxee.spring.homework1.service;

import ru.aaxee.spring.homework1.entity.QuizResult;
import ru.aaxee.spring.homework1.entity.Student;

public interface ResultPrintService {
    void print(Student student, QuizResult quizResult);
}
