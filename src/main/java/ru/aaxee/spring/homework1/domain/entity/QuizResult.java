package ru.aaxee.spring.homework1.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class QuizResult {

    private int questionsCount;
    private int correctAnswersCount;
}
