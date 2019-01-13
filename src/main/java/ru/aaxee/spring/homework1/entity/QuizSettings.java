package ru.aaxee.spring.homework1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class QuizSettings {

    private String quizName;
    private int maxQuestions;
}
