package ru.aaxee.spring.homework1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class QuizQuestion {

    private String question;
    private String answer;
}
